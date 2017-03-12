/**
 * Created by Wangzf5 on 2017/3/2.
 */
public class Sort {

    public static <T extends  Comparable<? super T>>
    void selectSort(T[] a) {
        int index;
        T min;

        for (int i = 0; i < a.length - 1; i++) {
            index = i;
            min = a[index];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(min) < 0) {
                    index = j;
                    min = a[index];
                }
            }
            if (index != i) {
                a[index] = a[i];
                a[i] = min;
            }
        }
    }

    public static <T extends Comparable<? super T>>
    void bubbleSort(T[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a) {
        int j;
        for(int i = 1; i < a.length; i++) {
            T current = a[i];
            for (j = i - 1; j >= 0 && current.compareTo(a[j]) < 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = current;
        }
    }

    public static <T extends Comparable<? super T>>
    void shellSort(T[] a) {
        int i, j;
        int h = a.length / 2;

        while (h > 0) {
            for (i = h; i < a.length; i += h) {
                T current = a[i];
                for (j = i - h; j >= 0 && current.compareTo(a[j]) < 0; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = current;
            }
            h = h / 2;
        }
    }

    public static <T extends Comparable<? super T>>
    void heapAdjust(T[] a, int bound, int index, int parent) {
        if (index == -1 || index == 0) {
            return;
        }

        int child1 = index * 2 + 1, child2 = index * 2 + 2, maxChild = -1;

        if (a[parent].compareTo(a[index]) < 0) {
            swap(a, parent, index);
        }

        if (child2 < bound) {
            maxChild = a[child1].compareTo(a[child2]) > 0 ? child1 : child2;
        } else if (child1 == bound - 1) {
            maxChild = child1;
        }
        heapAdjust(a, bound, maxChild, index);
    }

    public static <T>
    void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<? super T>>
    void heapSort(T[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            heapAdjust(a, a.length, i, (i - 1) / 2);
        }

        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            for (int j = i - 1; j > 0; j--) {
                heapAdjust(a, i, j, (j - 1) / 2);
            }
        }
    }

    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] s, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, s, left, center);
            mergeSort(a, s, center + 1, right);
            merge(a, s, left, center + 1, right);
        }
    }

    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] s, int left, int center, int right) {
        int i = left, l = left, r = center;
        while (l < center && r <= right) {
            if (a[l].compareTo(a[r]) < 0){
                s[i++] = a[l++];
            } else {
                s[i++] = a[r++];
            }
        }

        while (l < center) {
            s[i++] = a[l++];
        }
        while (r <= right) {
            s[i++] = a[r++];
        }

        int length = right - left + 1;
        for (i = 0; i < length; i++) {
            a[left + i] = s[left + i];
        }
    }

    public static <T extends Comparable<? super T>>
    void quickSort(T[] a, int left, int right) {
        if (right - left == 0) {
            return;
        }

        int mediumNumIndex = findMediumNumIndex(a, left, right);
        T middle = a[mediumNumIndex];
        if (mediumNumIndex != right) {
            swap(a, mediumNumIndex, right);
        }

        int i = left, j = right - 1;
        while (i <= j) {
            while (i <= j && a[i].compareTo(middle) < 0) {
                i++;
            }
            while (i <= j && a[j].compareTo(middle) > 0) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, i, right);

        quickSort(a, left, i);
        quickSort(a, i + 1, right);
    }

    private static <T extends Comparable<? super T>>
    int findMediumNumIndex(T[] a, int left, int right) {
        int centerIndex = (right - left) / 2;
        if (a[left].compareTo(a[centerIndex]) >= 0 && a[left].compareTo(a[right]) <= 0 ||
                a[left].compareTo(a[centerIndex]) <= 0 && a[left].compareTo(a[right]) >= 0) {
            return left;
        } else if (a[centerIndex].compareTo(a[left]) >= 0 && a[centerIndex].compareTo(a[right]) <= 0 ||
                a[centerIndex].compareTo(a[left]) <= 0 && a[centerIndex].compareTo(a[right]) >= 0) {
            return centerIndex;
        } else {
            return right;
        }
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (Integer i : a) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] radixSort(int[] a) {
        int[] digits = new int[a.length];

        int max = findMax(a);

        int base = 1;
        while (max / base > 0) {
            for (int i = 0; i < a.length; i++) {
                digits[i] = a[i] % (10 * base) / base;
            }

            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (digits[j] > digits[j + 1]) {
                        swap(digits, j, j + 1);
                        swap(a, j, j + 1);
                    }
                }
            }

            base *= 10;
        }

        return a;
    }

    public static void main(String[] args) {
        //int[] a = new int[]{34, 8, 64, 51, 32, 21};
        Integer[] a = new Integer[]{34, 8, 64, 51, 32, 21};
        int[] b = new int[]{1, 3, 4, 5, 2, 6, 9, 7, 8, 0};

        /*selectSort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/

        bubbleSort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();

        /*insertionSort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/

        /*shellSort(b);
        for (Integer i : b) {
            System.out.print(i + " ");
        }

        System.out.println();*/


        /*heapSort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/

        /*mergeSort(a, new Integer[a.length], 0, a.length - 1);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/

        /*quickSort(a, 0, a.length - 1);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/

        /*a = radixSort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

        System.out.println();*/
    }
}

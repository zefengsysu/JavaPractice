 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Comparator;
 import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("egg", 21));
        users.add(new User("gg", 29));
        users.add(new User("niu", 22));

        /*Collections.sort(users);
        for (User user : users) {
            System.out.println(user.getName() + " " + user.getAge());
        }*/

        UserComparator comparator = new UserComparator();
        Collections.sort(users, comparator);
        for (User user : users) {
            System.out.println(user.getUsername() + " " + user.getAge());
        }
    }

}

 /*@SuppressWarnings("unchecked")
 class User implements Comparable {
     private String name;
     private int age;

     public User(String name, int age) {
         super();
         this.name = name;
         this.age = age;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     @Override
     public int compareTo(Object o) {
         return this.age - ((User) o).getAge();
     }
 }*/

class User {
    private String username;
    private int age;

    public User(String username, int age) {
        super();
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        int age1 = user1.getAge();
        int age2 = user2.getAge();

        return Integer.compare(age1, age2);
        /*if (age1 < age2) {
            return 0;
        }
        return 1;*/
    }

}

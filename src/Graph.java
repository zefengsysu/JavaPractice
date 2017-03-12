import java.util.*;

/**
 * Created by Wangzf5 on 2017/3/12.
 */
public class Graph {
    private List<Vertex> vertices;

    public Graph() {}

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void topSort() throws CycleFoundException {
        if (vertices == null) {
            return;
        }

        Queue<Vertex> degree0s = new LinkedList<>();
        List<Vertex> mVertices = new ArrayList<>();
        mVertices.addAll(vertices);
        vertices.clear();

        for (int i = 0; i < mVertices.size(); i++) {
            Vertex v = mVertices.get(i);
            if (v.getIndegree() == 0) {
                degree0s.offer(v);
            }
        }

        int order = 0;
        while (!degree0s.isEmpty()) {
            Vertex current = degree0s.poll();
            mVertices.get(mVertices.indexOf(current)).setTopNum(order++);
            current.setTopNum(order);
            vertices.add(current);

            List<Vertex> adjacentVertices = current.getAdjacentVertices();
            if (adjacentVertices instanceof RandomAccess) {
                for (int i = 0; i < adjacentVertices.size(); i++) {
                    Vertex v = adjacentVertices.get(i);
                    v.setIndegree(v.getIndegree() - 1);

                    if (v.getIndegree() == 0) {
                        degree0s.offer(v);
                    }
                }
            } else {
                for (Vertex v : adjacentVertices) {
                    v.setIndegree(v.getIndegree() - 1);

                    if (v.getIndegree() == 0) {
                        degree0s.offer(v);
                    }
                }
            }
            mVertices.remove(current);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        List<Vertex> v0adjacentVertices = new ArrayList<>();
        List<Vertex> v1adjacentVertices = new ArrayList<>();
        List<Vertex> v2adjacentVertices = new ArrayList<>();
        List<Vertex> v3adjacentVertices = new ArrayList<>();


        v0adjacentVertices.add(v1);
        v0adjacentVertices.add(v3);
        v1adjacentVertices.add(v2);
        v2adjacentVertices.add(v3);

        v0.setAdjacentVertices(v0adjacentVertices);
        v1.setAdjacentVertices(v1adjacentVertices);
        v2.setAdjacentVertices(v2adjacentVertices);
        v3.setAdjacentVertices(v3adjacentVertices);

        v0.setIndegree(0);
        v1.setIndegree(1);
        v2.setIndegree(1);
        v3.setIndegree(1);

        List<Vertex> vertices = new ArrayList<>();

        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        g.setVertices(vertices);

        try {
            g.topSort();
        } catch (CycleFoundException e) {
            e.printStackTrace();
        }

        for (Vertex v : g.getVertices()) {
            System.out.print(v.getTopNum());
        }
    }
}

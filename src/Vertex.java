import java.util.List;

/**
 * Created by Wangzf5 on 2017/3/12.
 */
public class Vertex {
    private int topNum = -1;
    private int indegree;
    private List<Vertex> adjacentVertices;

    public Vertex() {}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            return ((Vertex)obj).getTopNum() == this.topNum &&
                    ((Vertex)obj).getIndegree() == this.indegree &&
                    ((Vertex)obj).getAdjacentVertices() == this.adjacentVertices;
        }

        return false;
    }

    public void setTopNum(int topNum) {
        this.topNum = topNum;
    }

    public int getTopNum() {
        return this.topNum;
    }

    public void setAdjacentVertices(List<Vertex> adjacentVertices) {
        if (adjacentVertices != null) {
            this.adjacentVertices = adjacentVertices;
        }
    }

    public List<Vertex> getAdjacentVertices() {
        return this.adjacentVertices;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public int getIndegree() {
        return this.indegree;
    }
}

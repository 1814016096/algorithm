package origin.algorithm.graph.weightundi;

/**
 * @author 原初
 * @create 2022 - 04 - 08
 * 边
 */
public class Side implements Comparable<Side> {
    private int oneVertex;
    private int otherVertex;
    private double weight;

    public Side(int oneVertex, int otherVertex, double weight) {
        this.oneVertex = oneVertex;
        this.otherVertex = otherVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return oneVertex + "<->" + otherVertex;
    }

    public int getOneVertex() {
        return oneVertex;
    }

    public void setOneVertex(int oneVertex) {
        this.oneVertex = oneVertex;
    }

    public int getOtherVertex() {
        return otherVertex;
    }
    public int getDiff(int v)
    {
        return v == oneVertex ? otherVertex : oneVertex;
    }
    public void setOtherVertex(int otherVertex) {
        this.otherVertex = otherVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Side o) {
        return Double.compare(weight, o.weight);
    }
}

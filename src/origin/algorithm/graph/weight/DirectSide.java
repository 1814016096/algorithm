package origin.algorithm.graph.weight;

/**
 * @author 原初
 * @create 2022 - 04 - 11
 * 有向边
 */
public class DirectSide {
    private int from;
    private int to;
    private double weight;

    public DirectSide(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return from + "<->" + to + ":" + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectSide that = (DirectSide) o;

        if (from != that.from) return false;
        return to == that.to;
    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + to;
        return result;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

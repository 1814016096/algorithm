package origin.algorithm.dp;

import java.util.ArrayList;

/**
 * @author 原初
 * @create 2022 - 04 - 21
 * 01背包的解
 */
public class KnapsackProblem {
    private ArrayList<Cell[]> cells; //不同物品的不同重量的记录表
    private int totalWeight; //背包总重

    public KnapsackProblem(int weight){ //重量
        cells = new ArrayList<>();
        this.totalWeight = weight;
        cells.add(new Cell[weight + 1]); //初始化第一行
        for (int i = 0; i < weight + 1; i++) {
            Cell cell = new Cell();
            cell.setGood(new Goods(0, 0, "null"));
            cells.get(0)[i] = cell;
        }
    }
    public void insertGoods(String name, double weight, double value) //插入东西
    {
        cells.add(new Cell[totalWeight + 1]); // 插入
        cells.get(cells.size() - 1)[0] = new Cell(); //第一列不放东西
        cells.get(cells.size() - 1)[0].setGood(new Goods(value, weight, name)); //放个东西
    }

    public Cell optimization() //最优化方法
    {
        if(cells.size() <= 1)
        {
            return null; //根本没放东西
        }

        for (int i = 1; i < cells.size(); i++) {
            for (int j = 1; j < cells.get(i).length; j++) {
                cells.get(i)[j] = new Cell();
                if(cells.get(i)[0].getGood().getWeight() > j) //重量大于
                {
                    Cell cell = cells.get(i - 1)[j]; //获取上一次的最优解
                    cells.get(i)[j].setTotalValue(cell.getTotalValue());
                    for (Goods good : cell.getGoods()) {
                        cells.get(i)[j].getGoods().add(good);
                    }

                }else{
                    int pos = (int) (j - cells.get(i)[0].getGood().getWeight());
                    pos = pos > 0 ? pos : 0;
                    if(cells.get(i - 1)[j].getTotalValue() > cells.get(i)[0].getGood().getValue() +
                            cells.get(i - 1)[pos].getTotalValue())
                    {
                        Cell cell = cells.get(i - 1)[j];

                        cells.get(i)[j].setTotalValue(cell.getTotalValue());
                        for (Goods good : cell.getGoods()) {
                            cells.get(i)[j].getGoods().add(good);
                        }
                    }else{
                        Cell cell = cells.get(i - 1)[pos];
                        double totalValue = cell.getTotalValue();
                        cells.get(i)[j].setTotalValue(cells.get(i)[0].getGood().getValue() + totalValue);
                        for (Goods good : cell.getGoods()) {
                            cells.get(i)[j].getGoods().add(good);
                        }
                        cells.get(i)[j].getGoods().add(cells.get(i)[0].getGood());
                    }
                }
            }
        }
        return cells.get(cells.size() - 1)[totalWeight];
    }
}

//背包格
class Cell{
    private double totalValue; //这个格子的总价值
    private Goods good; //这个格子代表什么东西
    private ArrayList<Goods> goods; //物品

    @Override
    public String toString() {
        return "Cell{" +
                "totalValue=" + totalValue  +
                ", goods=" + goods +
                '}';
    }

    public Cell(double totalValue, Goods good) {
        this.totalValue = totalValue;
        this.good = good;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Cell(double totalValue) {
        this.totalValue = totalValue;
        goods = new ArrayList<>();
    }
    public Cell() {
        this.totalValue = 0;
        goods = new ArrayList<>();
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }
}

//背包的东西
class Goods{
    private double value;
    private double weight; //重量和价值
    private String name;

    public Goods(String name) {
        this.name = name;
    }

    public Goods() {
    }

    public Goods(double value, double weight, String name) {
        this.value = value;
        this.weight = weight;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "value=" + value +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

package origin.algorithm.ga;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author 原初
 * @create 2022 - 04 - 23
 * 贪心算法解决覆盖问题
 */
public class CoveringProblems {
    private HashSet<String> set = new HashSet<>();//set集合
    private ArrayList<Station> stations = new ArrayList<>();
    public void insertRegion(String region)
    {
        set.add(region);
    }
    public void insertRegions(String ... regions)
    {
        for (String region : regions) {
            insertRegion(region);
        }
    }
    public void insertStation(Station station)
    {
        stations.add(station);
    }

    /**
     * 贪心算法
     * @return
     */
    public ArrayList<Station> greedy(){
        int count = 0;
        ArrayList<Station> s = new ArrayList<>();
        while (!set.isEmpty() && count != this.stations.size()){ //直到不为空
            int maxCoverIndex = -1; //最大覆盖的地区
            int maxCoverCount = 0; //最大覆盖数
            for (int i = 0; i < this.stations.size(); i++) {
                Station station = this.stations.get(i);
                int coverCount = 0; //覆盖数
                for (String region : station.getRegions()) {
                    if(set.contains(region)){
                        coverCount++;
                    }
                }
                if(coverCount == 0){
                    count++;
                }
                if(coverCount > maxCoverCount)
                {
                    maxCoverCount = coverCount;
                    maxCoverIndex = i;
                }
            }
            s.add(this.stations.get(maxCoverIndex));
            for (String region : this.stations.get(maxCoverIndex).getRegions()) {
                set.remove(region); //删掉有的
            }
        }
        if(!set.isEmpty())
        {
            return null;
        }else{
            return s;
        }
    }
}

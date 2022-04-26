package origin.algorithm.ga;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 04 - 23
 */
public class Station {
    String[] regions; //地区
    String name;

    public Station(String name, String ... regions) {
        this.regions = Arrays.copyOf(regions, regions.length);
        this.name = name;
    }

    public String[] getRegions() {
        return regions;
    }

    @Override
    public String toString() {
        return "Station{" +
                "regions=" + Arrays.toString(regions) +
                ", name='" + name + '\'' +
                '}';
    }
}

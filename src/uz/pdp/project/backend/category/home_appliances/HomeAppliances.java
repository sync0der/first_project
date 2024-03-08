package uz.pdp.project.backend.category.home_appliances;

import java.util.TreeMap;

public class HomeAppliances {
    public TreeMap<Integer, String> homeAppliancesMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> homeAppliancesMap = new TreeMap<>();
    public final DecorAndInterior decorAndInterior = new DecorAndInterior();
    public final HouseHoldGoods houseHoldGoods = new HouseHoldGoods();

    public HomeAppliances() {
       int size = 0;
       homeAppliancesMapToDisplay.put(++size, "Decor&Interior");
       homeAppliancesMapToDisplay.put(++size, "Household goods");

       homeAppliancesMap.putAll(decorAndInterior.decorAndInteriorList);
       homeAppliancesMap.putAll(houseHoldGoods.houseHoldGoodsList);
    }
}

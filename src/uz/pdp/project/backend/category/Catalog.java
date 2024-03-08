package uz.pdp.project.backend.category;

import uz.pdp.project.backend.category.accessories.Accessories;
import uz.pdp.project.backend.category.beauty_and_health.BeautyAndHealth;
import uz.pdp.project.backend.category.clothing.Clothing;
import uz.pdp.project.backend.category.electronics.Electronics;
import uz.pdp.project.backend.category.furniture.Furniture;
import uz.pdp.project.backend.category.home_appliances.HomeAppliances;
import uz.pdp.project.backend.category.shoes.Shoes;

import java.util.TreeMap;

public class Catalog {
    public TreeMap<Integer, String> catalogMapToDisplay = new TreeMap<>();
    public TreeMap<String, Double> catalogMap = new TreeMap<>();


    public Catalog() {
        int size = 0;
        catalogMapToDisplay.put(++size, "Accessories");
        catalogMapToDisplay.put(++size, "Beauty&Health");
        catalogMapToDisplay.put(++size, "Clothing");
        catalogMapToDisplay.put(++size, "Electronics");
        catalogMapToDisplay.put(++size, "Furniture");
        catalogMapToDisplay.put(++size, "Home Appliances");
        catalogMapToDisplay.put(++size, "Shoes");

        catalogMap.putAll(Accessories.accessoriesMap);
        catalogMap.putAll(BeautyAndHealth.beautyAndHealthMap);
        catalogMap.putAll(Clothing.clothesMap);
        catalogMap.putAll(Electronics.electronicsMap);
        catalogMap.putAll(Furniture.furnitureMap);
        catalogMap.putAll(HomeAppliances.homeAppliancesMap);
        catalogMap.putAll(Shoes.shoesMap);
    }
    public void addNewCategories(String str, TreeMap<String, Double> treeMap){
        int size = catalogMapToDisplay.size();
        catalogMapToDisplay.put(++size, str);
        catalogMap.putAll(treeMap);
    }



}

package uz.pdp.project.backend.category.accessories;

import java.util.TreeMap;

public class Accessories {
    public TreeMap<Integer, String> accessoriesMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> accessoriesMap = new TreeMap<>();
    public final MensJewellery mensJewellery = new MensJewellery();
    public final WomensJewellery womensJewellery = new WomensJewellery();

    public Accessories() {
        int size = 0;
        accessoriesMapToDisplay.put(++size, "Men's Jewellery");
        accessoriesMapToDisplay.put(++size, "Women's Jewellery");

        accessoriesMap.putAll(mensJewellery.jewelleryList);
        accessoriesMap.putAll(womensJewellery.womensJewelleryList);
    }
}

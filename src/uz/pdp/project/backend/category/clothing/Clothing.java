package uz.pdp.project.backend.category.clothing;

import java.util.TreeMap;

public class Clothing {
    public TreeMap<Integer, String> clothesMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> clothesMap = new TreeMap<>();
    public final ChildrenClothing childrenClothing = new ChildrenClothing();
    public final MensClothing mensClothing = new MensClothing();
    public final WomensClothing womensClothing = new WomensClothing();

    public Clothing() {
        int size = 0;
        clothesMapToDisplay.put(++size, "Children's Clothing");
        clothesMapToDisplay.put(++size, "Men's Clothing");
        clothesMapToDisplay.put(++size, "Women's Clothing");

        clothesMap.putAll(childrenClothing.childrenClothingList);
        clothesMap.putAll(mensClothing.mensClothingList);
        clothesMap.putAll(womensClothing.womensClothingList);
    }
}

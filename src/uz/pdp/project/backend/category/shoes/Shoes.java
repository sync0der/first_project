package uz.pdp.project.backend.category.shoes;

import java.util.TreeMap;

public class Shoes {
    public TreeMap<Integer, String> shoesMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> shoesMap = new TreeMap<>();
    public final MensShoes mensShoes = new MensShoes();
    public final WomensShoes womensShoes = new WomensShoes();

    public Shoes() {
        int size = 0;
        shoesMapToDisplay.put(++size, "Men's shoes");
        shoesMapToDisplay.put(++size, "Women's shoes");

        shoesMap.putAll(mensShoes.mensShoesList);
        shoesMap.putAll(womensShoes.womensShoesList);
    }
}

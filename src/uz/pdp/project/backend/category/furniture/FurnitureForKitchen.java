package uz.pdp.project.backend.category.furniture;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class FurnitureForKitchen {
    public TreeMap<String, Double> kitcheSetList = new TreeMap<>();

    public FurnitureForKitchen() {
        kitcheSetList.put("Кухонный обеденный", 12200000.0);
        kitcheSetList.put("Барный стул Caroline", 1106023.0);
    }
}

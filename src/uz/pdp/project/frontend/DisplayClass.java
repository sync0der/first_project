package uz.pdp.project.frontend;

import java.util.Map;
import java.util.TreeMap;

public class DisplayClass {
    public void displaySubCatalog(TreeMap<String, Double> treeMap) {
        int i = 1;
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            System.out.printf(i++ + ") " + entry.getKey() + " -> " + "%.1f" + " UZS%n", entry.getValue());
        }
    }
    public void displaySubCategories(TreeMap<Integer, String> treeMap2){
        treeMap2.forEach((k, v) -> System.out.println(k + ") " + v));
    }
    public void displayMap(TreeMap<Map.Entry<String, Double>, String> treeMap) {
        for (Map.Entry<Map.Entry<String, Double>, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " UZS  |\u001b[38;5;83m" + entry.getValue() + "\u001b[0m");
        }

    }

    public void displayNameOfTheCategory(String str) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\u001b[38;5;208m" + str + "\u001b[0m");
    }


}

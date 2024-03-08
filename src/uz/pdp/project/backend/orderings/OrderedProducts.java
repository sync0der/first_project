package uz.pdp.project.backend.orderings;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class OrderedProducts {
    public static TreeMap<Map.Entry<String, Double>, String>  orderedProducts = new TreeMap<>(Map.Entry.comparingByKey());
}

package uz.pdp.project.backend.recommendings;

import java.util.*;

public class RecommendedProducts {
    public TreeMap<String, Double> recProducts = new TreeMap<>();
    public void fillRecProducts(TreeMap<String, Double> treeMap){
        List<Map.Entry<String, Double>> list = new ArrayList<>(treeMap.entrySet());
        Map.Entry<String, Double> entry;
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < 15; i++) {
            randomIndex = random.nextInt(list.size());
            entry = list.get(randomIndex);
            recProducts.put(entry.getKey(), entry.getValue());
        }
    }


}

package uz.pdp.project.backend.category.electronics;

import java.util.TreeMap;

public class Smartphones {
    public TreeMap<String, Double> smartphonesList = new TreeMap<>();

    public Smartphones() {
        smartphonesList.put("Xiaomi Redmi Note 13 Pro 8/256 ГБ", 3649000.0);
        smartphonesList.put("Honor X8b 8/128 ГБ", 3229000.0);
        smartphonesList.put("Samsung Galaxy A24 6/128 ГБ", 2449000.0);
        smartphonesList.put("Infinix Hot 40i 16/256 ГБ", 1799000.0);
        smartphonesList.put("Samsung Galaxy S22 Global 5g 8/128 ГБ", 15000000.0);
        smartphonesList.put("Samsung Galaxy A05 4/128 ГБ", 2000000.0);
        smartphonesList.put("Samsung Galaxy A15 6/128 ГБ", 1999000.0);
        smartphonesList.put("Techno Spark Go 2024 4/64 ГБ", 2230000.0);
        smartphonesList.put("Apple iPhone 13 black 128 ГБ", 13999000.0);
        smartphonesList.put("Apple iPhone 15 Global 128 ГБ", 1434000.0);
        smartphonesList.put("Apple iPhone 14 nano-SIM + e-SIM 5G 128 ГБ", 11583000.0);

//        int key = 1;
//        for (Map.Entry<String, Integer> entry : smartphonesList.entrySet()) {
//            TreeMap<String, Integer> map = new TreeMap<>();
//            map.put(entry.getKey(), entry.getValue());
//            nums.put(key++, map);
//        }
    }


}

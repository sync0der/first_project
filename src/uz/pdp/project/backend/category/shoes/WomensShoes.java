package uz.pdp.project.backend.category.shoes;

import java.util.TreeMap;

public class WomensShoes {
    public TreeMap<String, Double> womensShoesList = new TreeMap<>();

    public WomensShoes() {
        womensShoesList.put("Кроссовки женские, повседневные", 179000.0);
        womensShoesList.put("Женские туфли на толстом каблуке с платформой 7 см", 416000.0);
        womensShoesList.put("Туфли женские, вечерние, покрытые жемчугом", 886000.0);
    }
}

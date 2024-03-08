package uz.pdp.project.backend.category.beauty_and_health;

import java.util.TreeMap;

public class BeautyAndHealth {
    public TreeMap<Integer, String> beautyAndHealthMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> beautyAndHealthMap = new TreeMap<>();
    public final BodyCare bodyCare = new BodyCare();
    public final MakeUp makeUp = new MakeUp();
    public final Perfume perfume = new Perfume();

    public BeautyAndHealth() {
        int size = 0;
        beautyAndHealthMapToDisplay.put(++size, "Body care");
        beautyAndHealthMapToDisplay.put(++size, "Make-up");
        beautyAndHealthMapToDisplay.put(++size, "Perfume");

        beautyAndHealthMap.putAll(bodyCare.bodyCareList);
        beautyAndHealthMap.putAll(makeUp.makeUpList);
        beautyAndHealthMap.putAll(perfume.perfumeList);
    }
}

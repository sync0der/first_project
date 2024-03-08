package uz.pdp.project.backend.category.furniture;

import java.util.TreeMap;

public class Furniture {
    public TreeMap<Integer, String> furnitureMapToDisplay = new TreeMap<>();
    public static TreeMap<String, Double> furnitureMap = new TreeMap<>();
    public final FurnitureForBedRoom furnitureForBedRoom = new FurnitureForBedRoom();
    public final FurnitureForKitchen furnitureForKitchen = new FurnitureForKitchen();
    public final FurnitureForLivingRoom furnitureForLivingRoom = new FurnitureForLivingRoom();

    public Furniture() {
        int size = 0;
        furnitureMapToDisplay.put(++size, "Bedroom furniture");
        furnitureMapToDisplay.put(++size, "Kitchen furniture");
        furnitureMapToDisplay.put(++size, "Living room furniture");

        furnitureMap.putAll(furnitureForBedRoom.bedroomSetList);
        furnitureMap.putAll(furnitureForKitchen.kitcheSetList);
        furnitureMap.putAll(furnitureForLivingRoom.livingRoomSet);
    }
}
package uz.pdp.project.backend.category.electronics;

import java.util.TreeMap;

public class Electronics {

  public TreeMap<Integer, String> electronicsMapToDisplay = new TreeMap<>();
  public static TreeMap<String, Double> electronicsMap = new TreeMap<>();
  public final Headphones headphones = new Headphones();
  public final Laptops laptops = new Laptops();
  public final Smartphones smartphones = new Smartphones();
  public final Smartwatches  smartwatches = new Smartwatches();
  public final Televisions televisions = new Televisions();


    public Electronics() {
        int size = 0;
        electronicsMapToDisplay.put(++size, "Headphones");
        electronicsMapToDisplay.put(++size, "Laptops");
        electronicsMapToDisplay.put(++size, "Smartphones");
        electronicsMapToDisplay.put(++size, "Smartwatches");
        electronicsMapToDisplay.put(++size, "Televisions");

        electronicsMap.putAll(headphones.headphonesList);
        electronicsMap.putAll(laptops.laptopList);
        electronicsMap.putAll(smartphones.smartphonesList);
        electronicsMap.putAll(smartwatches.smartwatchesList);
        electronicsMap.putAll(televisions.televisionsList);
    }

}

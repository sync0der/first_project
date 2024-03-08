package uz.pdp.project.backend.category.home_appliances;

import java.util.TreeMap;

public class HouseHoldGoods {
    public TreeMap<String, Double> houseHoldGoodsList = new TreeMap<>();

    public HouseHoldGoods() {
        houseHoldGoodsList.put("Таз складной силиконовый, хозяйственный", 199000.0);
        houseHoldGoodsList.put("Перчатки для хозяйства, резиновые", 11000.0);
        houseHoldGoodsList.put("Комплект для уборки, веник с совком, щетка для уборки пола, совок для мусора", 59000.0);
    }
}

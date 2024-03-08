package uz.pdp.project.backend.roles;

import uz.pdp.project.backend.favourites.FavouriteProducts;
import uz.pdp.project.backend.orderings.Basket;
import uz.pdp.project.backend.payments.UserBankCards;

import java.util.*;

public class User{
    public TreeMap<String, Double> findProduct(String s, TreeMap<String, Double> treeMap) {
        char[] c = s.toLowerCase().toCharArray();
        return findProductInCategory(treeMap, c);
    }

    public TreeMap<String, Double> findProductInCategory(TreeMap<String, Double> treeMap, char[] c) {
        TreeMap<String, Double> foundList = new TreeMap<>();
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            String str = entry.getKey().toLowerCase();
            char[] charArray = str.toCharArray();
            if ((Arrays.compare(charArray, 0, c.length, c, 0, c.length) == 0)) {
                foundList.put(entry.getKey(), entry.getValue());
            }
        }
        return foundList;
    }

    public void addProductToFavouritesList(Map.Entry<String, Double> entry) {
        if (entry == null) {
            return;
        }
        FavouriteProducts.favouritesMap.put(entry.getKey(), entry.getValue());
    }

public <K, V> Map.Entry<K, V> get(int i, TreeMap<K, V> treeMap) {
    if (treeMap == null)
        return null;
    int counter = 0;
    for (Map.Entry<K, V> entry : treeMap.entrySet()) {
        counter++;
        if (counter == i)
            return entry;
    }
    return null;
}

    public <K, V> void order(Map.Entry<K, V> entry) {
        if (entry == null) {
            return;
        }
        Basket.basket.put((String) entry.getKey(), (Double) entry.getValue());
    }

    public void addBankCard(TreeMap<String, Double> treeMap, Scanner scanner) {
        Random random = new Random();
        System.out.print("\u001b[38;5;27mEnter card name: ");
        String cardInfo = scanner.nextLine();
        System.out.print("Enter card number: ");
        cardInfo = cardInfo.concat("[" + scanner.nextLine());
        System.out.print("Enter card expire date(dd/mm): \u001b[0m");
        cardInfo = cardInfo.concat("] " + scanner.nextLine());
        treeMap.put(cardInfo, random.nextDouble(1500000.0, 5200000.0));
    }

    public Map.Entry<String, Double> topUpTheBankCard(Double amount, Map.Entry<String, Double> entry) {
        Double value = entry.getValue();
        entry.setValue(amount + value);
        return entry;
    }

    public void operationsWithBankCard(Scanner scanner) {
        if (!UserBankCards.bankCard.isEmpty()) {
            System.out.println("\n\u001b[38;5;27mTop up a bank account:   ->    1\u001b[0m");
        }
        System.out.println("\u001b[38;5;27mAdd a new bank card:     ->    2\u001b[0m");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                if (!UserBankCards.bankCard.isEmpty()) {
                    System.out.print("\u001b[38;5;27mChoose the card number: \u001b[0m");
                    Map.Entry<String, Double> entry = get(scanner.nextInt(), UserBankCards.bankCard);
                    System.out.printf(entry.getKey() + " --> " + "%.1f" + " UZS%n", entry.getValue());
                    System.out.print("\u001b[38;5;27mEnter amount(in UZS): \u001b[0m");
                    Map.Entry<String, Double> entry1 = topUpTheBankCard(scanner.nextDouble(), entry);
                    UserBankCards.bankCard.put(entry1.getKey(), entry1.getValue());
                    System.out.println("\n\u001b[38;5;51mAccount Refilled\u001b[0m");
                    break;
                }
            case 2:
                addBankCard(UserBankCards.bankCard, scanner);
                System.out.println("\n\u001b[38;5;51mAdded\u001b[0m");
                break;
            default:
                System.out.println("\n\u001b[38;5;196mInvalid value\u001b[0m");
                break;
        }
    }

    public Double payByPromo(String str) {
        str = str.substring(0, 2);
        System.out.println("\u001b[38;5;51mGreat! You have just used a promo-code for " + str + "% discount\u001b[0m");
        return Double.parseDouble(str) / 100; // 25 / 100 = 0.25
    }

}

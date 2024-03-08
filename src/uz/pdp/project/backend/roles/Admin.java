package uz.pdp.project.backend.roles;

import java.util.*;

public class Admin {


     public void createProduct(Scanner scanner1, Scanner scanner, TreeMap<String, Double> treeMap) {
        System.out.print("\u001b[38;5;27mProduct name: ");
        String name = scanner1.nextLine();
        System.out.print("Product price: \u001b[0m");
        double price = scanner.nextDouble();
        treeMap.put(name, price);
        System.out.println("\n\u001b[38;5;51mCreated\n\u001b[0m");
    }

    public void deleteProduct(TreeMap<String, Double> treeMap, String key) {
        treeMap.remove(key);
        System.out.println("\u001b[38;5;51mDeleted!\u001b[0m");
    }

    public void blockUser(Map.Entry<String, String> entry, TreeMap<String, String> whichList, TreeMap<String, String> blockList){
        whichList.remove(entry.getKey(), entry.getValue());
        blockList.put(entry.getKey(), entry.getValue());
        System.out.println("\n\u001b[38;5;51mBlocked!\u001b[0m");
    }
    public void unblockUser(Map.Entry<String, String> entry, TreeMap<String, String> blockList, TreeMap<String, String> whichList){
        blockList.remove(entry.getKey(),  entry.getValue());
        whichList.put(entry.getKey(), entry.getValue());
        System.out.println("\n\u001b[38;5;51mUnblocked\u001b[0m");
    }


    public String findProductNameInTreeMap(TreeMap<String, Double> treeMap) {
        Set<String> set = treeMap.keySet();
        ArrayList<String> arrayList = new ArrayList<>(set);
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println((i + 1) + " - " + arrayList.get(i));
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001b[38;5;27mChoose the number of the product: \u001b[0m");
        int prodNum = scanner.nextInt();
        return arrayList.get(prodNum - 1);
    }
}

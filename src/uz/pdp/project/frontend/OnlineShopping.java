package uz.pdp.project.frontend;

import uz.pdp.project.backend.category.Catalog;
import uz.pdp.project.backend.category.accessories.Accessories;
import uz.pdp.project.backend.category.beauty_and_health.BeautyAndHealth;
import uz.pdp.project.backend.category.clothing.Clothing;
import uz.pdp.project.backend.category.electronics.Electronics;
import uz.pdp.project.backend.category.furniture.Furniture;
import uz.pdp.project.backend.category.home_appliances.HomeAppliances;
import uz.pdp.project.backend.category.shoes.Shoes;
import uz.pdp.project.backend.favourites.FavouriteProducts;
import uz.pdp.project.backend.orderings.Basket;
import uz.pdp.project.backend.orderings.OrderedProducts;
import uz.pdp.project.backend.payments.PromoCodes;
import uz.pdp.project.backend.payments.UserBankCards;
import uz.pdp.project.backend.recommendings.RecommendedProducts;
import uz.pdp.project.backend.roles.Admin;
import uz.pdp.project.backend.roles.BlockedUsers;
import uz.pdp.project.backend.roles.User;
import uz.pdp.project.backend.top_sales.TopSale;
import uz.pdp.project.database.UserProfiles;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OnlineShopping {
    public static User user = new User();
    public static Admin admin = new Admin();
    public static DisplayClass displayClass = new DisplayClass();

    public static void main(String[] args) {

        UserProfiles userProfiles = new UserProfiles();
        Accessories accessories = new Accessories();
        BeautyAndHealth beautyAndHealth = new BeautyAndHealth();
        Clothing clothing = new Clothing();
        Electronics electronics = new Electronics();
        Furniture furniture = new Furniture();
        HomeAppliances homeAppliances = new HomeAppliances();
        Shoes shoes = new Shoes();
        Catalog catalog = new Catalog();
        RecommendedProducts recommendedProducts = new RecommendedProducts();
        TopSale topSale = new TopSale();
        PromoCodes promoCodes = new PromoCodes();
        BlockedUsers blockedUsers = new BlockedUsers();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        int menu;
        int exitOrLog;
        int categories;
        int subCategories;
        boolean executed = false;
        boolean executedRecs = false;
        Properties properties = new Properties();
        boolean userIsFound = false;

        do {
            System.out.println("\u001b[38;5;27mLog in    ->    1");
            System.out.println("Exit      ->    0\u001b[0m");
            exitOrLog = scanner.nextInt();

            if (exitOrLog == 1) {
                System.out.println("\u001b[38;5;27mChoose a role: \u001b[0m\nUSER   --->    1\nADMIN  --->    2");
                int choice = scanner.nextInt();
                do {
                    if (choice == 1) {
                        System.out.println("\u001b[38;5;27mEnter your username: ");
                        String username = scanner1.nextLine();
                        System.out.println("Enter your password: \u001b[0m");
                        String password = scanner1.nextLine();

                        if (logIn(userProfiles.users, username, password)) {
                            userIsFound = true;
                            executed = false;
                            do {
                                if (!executed)
                                    System.out.println("\n\u001b[38;5;76m" + username + ", Welcome to All-In-One market\u001b[0m");
                                executed = true;
                                System.out.println("\n\u001b[38;5;162mRecommended products   -->     1");
                                System.out.println("Catalog                -->     2");
                                System.out.println("Find product           -->     3");
                                System.out.println("Top sale               -->     4");
                                System.out.println("Basket                 -->     5");
                                System.out.println("Favourites             -->     6");
                                System.out.println("Bank Cards             -->     7");
                                System.out.println("Orders                 -->     8");
                                System.out.println("Quit                   -->     0\u001b[0m");
                                menu = scanner.nextInt();
                                switch (menu) {
                                    case 1:
                                        if (!executedRecs) {
                                            recommendedProducts.fillRecProducts(catalog.catalogMap);
                                            executedRecs = true;
                                        }
                                        operationsWithProducts(scanner, recommendedProducts.recProducts, "Recommending");
                                        break;

                                    case 2:
                                        catalog.catalogMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                        System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                        categories = scanner.nextInt();
                                        outerLoop:
                                        switch (categories) {
                                            case 1:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(1));
                                                accessories.accessoriesMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, accessories.mensJewellery.jewelleryList, accessories.accessoriesMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, accessories.womensJewellery.womensJewelleryList, accessories.accessoriesMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;


                                                }
                                            case 2:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(2));
                                                beautyAndHealth.beautyAndHealthMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, beautyAndHealth.bodyCare.bodyCareList, beautyAndHealth.beautyAndHealthMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, beautyAndHealth.makeUp.makeUpList, beautyAndHealth.beautyAndHealthMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 3:
                                                        if (!operationsWithProducts(scanner, beautyAndHealth.perfume.perfumeList, beautyAndHealth.beautyAndHealthMapToDisplay.get(3)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }

                                            case 3:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(3));
                                                clothing.clothesMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, clothing.childrenClothing.childrenClothingList, clothing.clothesMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, clothing.mensClothing.mensClothingList, clothing.clothesMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 3:
                                                        if (!operationsWithProducts(scanner, clothing.womensClothing.womensClothingList, clothing.clothesMapToDisplay.get(3)))
                                                            break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }
                                            case 4:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(4));
                                                electronics.electronicsMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, electronics.headphones.headphonesList, electronics.electronicsMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, electronics.laptops.laptopList, electronics.electronicsMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 3:
                                                        if (!operationsWithProducts(scanner, electronics.smartphones.smartphonesList, electronics.electronicsMapToDisplay.get(3)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 4:
                                                        if (!operationsWithProducts(scanner, electronics.smartwatches.smartwatchesList, electronics.electronicsMapToDisplay.get(4)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 5:
                                                        if (!operationsWithProducts(scanner, electronics.televisions.televisionsList, electronics.electronicsMapToDisplay.get(5)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }
                                            case 5:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(5));
                                                furniture.furnitureMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, furniture.furnitureForBedRoom.bedroomSetList, furniture.furnitureMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, furniture.furnitureForKitchen.kitcheSetList, furniture.furnitureMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 3:
                                                        if (!operationsWithProducts(scanner, furniture.furnitureForLivingRoom.livingRoomSet, furniture.furnitureMapToDisplay.get(3)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.print("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }
                                            case 6:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(6));
                                                homeAppliances.homeAppliancesMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, homeAppliances.decorAndInterior.decorAndInteriorList, homeAppliances.homeAppliancesMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, homeAppliances.houseHoldGoods.houseHoldGoodsList, homeAppliances.homeAppliancesMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }
                                            case 7:
                                                displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(7));
                                                shoes.shoesMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\n\u001b[38;5;27mChoose one of the categories: \u001b[0m");
                                                subCategories = scanner.nextInt();
                                                switch (subCategories) {
                                                    case 1:
                                                        if (!operationsWithProducts(scanner, shoes.mensShoes.mensShoesList, shoes.shoesMapToDisplay.get(1)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    case 2:
                                                        if (!operationsWithProducts(scanner, shoes.womensShoes.womensShoesList, shoes.shoesMapToDisplay.get(2)))
                                                            break outerLoop;
                                                        break outerLoop;
                                                    default:
                                                        System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                        break outerLoop;
                                                }
                                            default:
                                                System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
                                                break;
                                        }
                                        break;

                                    case 3:
                                        System.out.println("\u001b[38;5;27mEnter product name: \u001b[0m");
                                        TreeMap<String, Double> product = user.findProduct(scanner1.nextLine(), catalog.catalogMap);
                                        if (product == null) {
                                            System.out.println("\n\u001b[38;5;196mNot Found\n\u001b[0m");
                                            break;
                                        }
                                        operationsWithProducts(scanner, product, "Found Results");
                                        break;
                                    case 4:
                                        operationsWithProducts(scanner, topSale.topSale, "Top sales of the season");
                                        break;
                                    case 5:
                                        if (Basket.basket.isEmpty()) {
                                            displayClass.displayNameOfTheCategory("\u001b[38;5;196mThe List is empty\u001b[38;5;0m");
                                            break;
                                        }
                                        displayClass.displayNameOfTheCategory("Basket");
                                        displayClass.displaySubCatalog(Basket.basket);
                                        System.out.println("\u001b[38;5;27mOrder   ->      1");
                                        System.out.println("Remove  ->      2");
                                        System.out.println("Back    ->      0\u001b[0m");
                                        int orderOrRemove = scanner.nextInt();
                                        if (orderOrRemove == 0)
                                            break;
                                        System.out.print("\u001b[38;5;27mChoose the number of the product: \u001b[0m");
                                        Map.Entry<String, Double> entry = user.get(scanner.nextInt(), Basket.basket);
                                        switch (orderOrRemove) {
                                            case 1:
                                                boolean promoIsFound = false;
                                                double price = entry.getValue();
                                                if (UserBankCards.bankCard.isEmpty()) {
                                                    System.out.print("\u001b[38;5;196mUnable to order. Bank Card is not found!\u001b[0m");
                                                    break;
                                                }
                                                displayClass.displayNameOfTheCategory("Bank Cards");
                                                displayClass.displaySubCatalog(UserBankCards.bankCard);
                                                System.out.print("\u001b[38;5;27mSelect a card for payment: \u001b[0m");
                                                Map.Entry<String, Double> entry1 = user.get(scanner.nextInt(), UserBankCards.bankCard);
                                                System.out.println("\u001b[38;5;27mPay with a promo-code     ->   1");
                                                System.out.println("Pay without a promo-code  ->   0\u001b[0m");
                                                int promoChoice = scanner.nextInt();
                                                if (promoChoice == 1) {
                                                    System.out.print("\u001b[38;5;27mEnter your promo-code: \u001b[0m");
                                                    String proCode = scanner1.nextLine();
                                                    for (String list : promoCodes.promos) {
                                                        if (proCode.equals(list)) {
                                                            Double v = user.payByPromo(proCode);
                                                            promoIsFound = true;
                                                            price = entry.getValue() * v;
                                                        }
                                                    }
                                                    if (!promoIsFound) {
                                                        System.out.println("\u001b[38;5;196mNot Found!\u001b[0m");
                                                        break;
                                                    }
                                                }

                                                if (entry.getValue() < entry1.getValue() || price < entry1.getValue()) {
                                                    if (promoChoice == 0) {
                                                        double amount = entry1.getValue() - entry.getValue();
                                                        entry1.setValue(amount);
                                                        System.out.printf("Paid: " + "%.1f" + "UZS%n", entry.getValue());
                                                    } else if (promoChoice == 1) {
                                                        double priceAfterPromo = entry.getValue() - price;
                                                        double amount = entry1.getValue() - priceAfterPromo;
                                                        entry1.setValue(amount);
                                                        System.out.printf("Paid: " + "%.1f" + " UZS%n", priceAfterPromo);
                                                    }
                                                    DateFormat date = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
                                                    String format = date.format(new Date());
                                                    OrderedProducts.orderedProducts.put(entry, "ordered and paid(" + format + ")");
                                                } else {
                                                    System.out.println("\u001b[38;5;196mUnable to pay, not enough money on your Bank Card\u001b[0m");
                                                }
                                                break;
                                            case 2:
                                                Basket.basket.remove(entry.getKey(), entry.getValue());
                                                System.out.println("\n\u001b[38;5;51mRemoved from the basket\u001b[0m");
                                                break;
                                            default:
                                                System.out.println("\u001b[38;5;196mInvalid Value\u001b[0m");
                                                break;
                                        }

                                        break;
                                    case 6:
                                        if (FavouriteProducts.favouritesMap.isEmpty()) {
                                            displayClass.displayNameOfTheCategory("\u001b[38;5;196mThe List is empty\u001b[0m");
                                            break;
                                        }
                                        displayClass.displayNameOfTheCategory("Favourite products");
                                        displayClass.displaySubCatalog(FavouriteProducts.favouritesMap);
                                        System.out.println("\u001b[38;5;27mAdd to the basket   ->   1");
                                        System.out.println("Remove              ->   2");
                                        System.out.println("Back                ->   0\u001b[0m");
                                        int opt = scanner.nextInt();
                                        if (opt == 0)
                                            break;
                                        System.out.print("\n\u001b[38;5;27mChoose the number of the product: \u001b[0m");
                                        Map.Entry<String, Double> favProd = user.get(scanner.nextInt(), FavouriteProducts.favouritesMap);
                                        System.out.printf("\n" + favProd.getKey() + " -> " + "%.1f" + " UZS%n", favProd.getValue());
                                        switch (opt) {
                                            case 1:
                                                user.order(favProd);
                                                System.out.println("\n\u001b[38;5;51mAdded to basket\n\u001b[0m");
                                                break;
                                            case 2:
                                                FavouriteProducts.favouritesMap.remove(favProd.getKey(), favProd.getValue());
                                                System.out.println("\u001b[38;5;51mRemoved from the favourites\u001b[0m");
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                    case 7:
                                        if (!UserBankCards.bankCard.isEmpty())
                                            displayClass.displayNameOfTheCategory("Bank Cards");
                                        else
                                            displayClass.displayNameOfTheCategory("\u001b[38;5;196mNo cards found\u001b[0m");
                                        displayClass.displaySubCatalog(UserBankCards.bankCard);
                                        user.operationsWithBankCard(scanner);
                                        break;
                                    case 8:
                                        displayClass.displayNameOfTheCategory("Orderings");
                                        if (OrderedProducts.orderedProducts.isEmpty()) {
                                            System.out.println("\u001b[38;5;196mEmpty\u001b[0m");
                                            break;
                                        }
                                        displayClass.displayMap(OrderedProducts.orderedProducts);
                                        break;
                                }

                            } while (menu != 0);

                        } else {
                            System.out.println("\u001b[38;5;196mUser not found! Try again!\u001b[0m");
                        }
                    }

                    if (choice == 2) {
                        System.out.println("\u001b[38;5;27mEnter your username: ");
                        String username = scanner1.nextLine();
                        System.out.println("Enter your password: \u001b[0m");
                        String password = scanner1.nextLine();
                        try {
                            FileReader fileReader = new FileReader("src/uz/pdp/project/database/adminAccounts.properties");
                            properties.load(fileReader);
                            fileReader.close();
                            if (Objects.equals(username, properties.getProperty("admin1.username")) && Objects.equals(password, properties.getProperty("admin1.password"))) {
                                userIsFound = true;
                                do {
                                    if (!executed) {
                                        System.out.println("\n\u001b[38;5;76m" + username + ", welcome to the admin panel\u001b[0m");
                                        executed = true;
                                    }
                                    System.out.println("\n\u001b[38;5;27mBlock users                    -->     1");
                                    System.out.println("Unblock users                  -->     2");
                                    System.out.println("Create/Delete a product        -->     3");
                                    System.out.println("Quit                           -->     0\u001b[0m");
                                    menu = scanner.nextInt();

                                    outerSwitch:
                                    switch (menu) {
                                        case 1:
                                            displayClass.displayNameOfTheCategory("User's Profile List");
                                            AtomicInteger i = new AtomicInteger(1);
                                            userProfiles.users.forEach((k, v) -> System.out.println(i.getAndIncrement() + ") username: " + k + " | password: " + v));
                                            System.out.print("\u001b[38;5;27mChoose a profile: \u001b[0m");
                                            admin.blockUser(user.get(scanner.nextInt(), userProfiles.users), userProfiles.users, blockedUsers.blockedUsers);
                                            break;
                                        case 2:
                                            displayClass.displayNameOfTheCategory("Blocked Users");
                                            if (blockedUsers.blockedUsers == null) {
                                                System.out.println("\u001b[38;5;196mEmpty\u001b[0m");
                                                break;
                                            }
                                            AtomicInteger j = new AtomicInteger(1);
                                            blockedUsers.blockedUsers.forEach((k, v) -> System.out.println(j.getAndIncrement() + ") username: " + k + " | password: " + v));
                                            System.out.print("\u001b[38;5;27mChoose a profile: \u001b[0m");
                                            admin.unblockUser(user.get(scanner.nextInt(), blockedUsers.blockedUsers), blockedUsers.blockedUsers, userProfiles.users);
                                            break;

                                        case 3:
                                            System.out.println("\u001b[38;5;27mCreate a product   ->   1");
                                            System.out.println("Delete a product   ->   2");
                                            System.out.println("Back               -> h  0\u001b[0m");
                                            int prodOperations;
                                            do {
                                                prodOperations = scanner.nextInt();
                                                displayClass.displayNameOfTheCategory("Catalog");
                                                catalog.catalogMapToDisplay.forEach((k, v) -> System.out.println(k + ") " + v));
                                                System.out.print("\u001b[38;5;27mChoose a category: \u001b[0m");
                                                switch (scanner.nextInt()) {
                                                    case 1:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(1));
                                                        displayClass.displaySubCategories(accessories.accessoriesMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, accessories.mensJewellery.jewelleryList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(accessories.accessoriesMapToDisplay.get(1));
                                                                    deleteProduct(accessories.mensJewellery.jewelleryList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;

                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, accessories.womensJewellery.womensJewelleryList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(accessories.accessoriesMapToDisplay.get(2));
                                                                    deleteProduct(accessories.womensJewellery.womensJewelleryList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 2:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(2));
                                                        displayClass.displaySubCategories(beautyAndHealth.beautyAndHealthMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, beautyAndHealth.bodyCare.bodyCareList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(beautyAndHealth.beautyAndHealthMapToDisplay.get(1));
                                                                    deleteProduct(beautyAndHealth.bodyCare.bodyCareList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, beautyAndHealth.makeUp.makeUpList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(beautyAndHealth.beautyAndHealthMapToDisplay.get(2));
                                                                    deleteProduct(beautyAndHealth.makeUp.makeUpList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 3 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, beautyAndHealth.perfume.perfumeList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(beautyAndHealth.beautyAndHealthMapToDisplay.get(3));
                                                                    deleteProduct(beautyAndHealth.perfume.perfumeList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 3:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(3));
                                                        displayClass.displaySubCategories(clothing.clothesMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, clothing.childrenClothing.childrenClothingList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(clothing.clothesMapToDisplay.get(1));
                                                                    deleteProduct(clothing.childrenClothing.childrenClothingList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, clothing.mensClothing.mensClothingList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(clothing.clothesMapToDisplay.get(2));
                                                                    deleteProduct(clothing.mensClothing.mensClothingList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 3 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, clothing.womensClothing.womensClothingList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(clothing.clothesMapToDisplay.get(3));
                                                                    deleteProduct(clothing.womensClothing.womensClothingList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 4:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(4));
                                                        displayClass.displaySubCategories(electronics.electronicsMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, electronics.headphones.headphonesList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(electronics.electronicsMapToDisplay.get(1));
                                                                    deleteProduct(electronics.headphones.headphonesList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, electronics.laptops.laptopList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(electronics.electronicsMapToDisplay.get(2));
                                                                    deleteProduct(electronics.laptops.laptopList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 3 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, electronics.smartphones.smartphonesList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(electronics.electronicsMapToDisplay.get(3));
                                                                    deleteProduct(electronics.smartphones.smartphonesList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 4 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, electronics.smartwatches.smartwatchesList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(electronics.electronicsMapToDisplay.get(4));
                                                                    deleteProduct(electronics.smartwatches.smartwatchesList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 5 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, electronics.televisions.televisionsList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(electronics.electronicsMapToDisplay.get(5));
                                                                    deleteProduct(electronics.televisions.televisionsList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 5:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(5));
                                                        displayClass.displaySubCategories(furniture.furnitureMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, furniture.furnitureForBedRoom.bedroomSetList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(furniture.furnitureMapToDisplay.get(1));
                                                                    deleteProduct(furniture.furnitureForBedRoom.bedroomSetList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, furniture.furnitureForKitchen.kitcheSetList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(furniture.furnitureMapToDisplay.get(2));
                                                                    deleteProduct(furniture.furnitureForKitchen.kitcheSetList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 3 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, furniture.furnitureForLivingRoom.livingRoomSet);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(furniture.furnitureMapToDisplay.get(3));
                                                                    deleteProduct(furniture.furnitureForLivingRoom.livingRoomSet, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 6:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(6));
                                                        displayClass.displaySubCategories(homeAppliances.homeAppliancesMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, homeAppliances.decorAndInterior.decorAndInteriorList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(homeAppliances.homeAppliancesMapToDisplay.get(1));
                                                                    deleteProduct(homeAppliances.decorAndInterior.decorAndInteriorList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, homeAppliances.houseHoldGoods.houseHoldGoodsList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(homeAppliances.homeAppliancesMapToDisplay.get(2));
                                                                    deleteProduct(homeAppliances.houseHoldGoods.houseHoldGoodsList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    case 7:
                                                        displayClass.displayNameOfTheCategory(catalog.catalogMapToDisplay.get(6));
                                                        displayClass.displaySubCategories(shoes.shoesMapToDisplay);
                                                        System.out.print("\u001b[38;5;27mChoose a subcategory: \u001b[0m");
                                                        switch (scanner.nextInt()) {
                                                            case 1 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, shoes.mensShoes.mensShoesList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(shoes.shoesMapToDisplay.get(1));
                                                                    deleteProduct(shoes.mensShoes.mensShoesList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                            case 2 -> {
                                                                if (prodOperations == 1) {
                                                                    admin.createProduct(scanner1, scanner, shoes.womensShoes.womensShoesList);
                                                                    break outerSwitch;
                                                                }
                                                                if (prodOperations == 2) {
                                                                    displayClass.displayNameOfTheCategory(shoes.shoesMapToDisplay.get(2));
                                                                    deleteProduct(shoes.womensShoes.womensShoesList, scanner, recommendedProducts);
                                                                    break outerSwitch;
                                                                }
                                                                break outerSwitch;
                                                            }
                                                        }
                                                        break outerSwitch;
                                                    default:
                                                        System.out.println("\u001b[38;5;196mInvalid value\u001b[0m");
                                                        break outerSwitch;
                                                }
                                            } while (prodOperations != 0);
                                        default:
                                            break;
                                    }
                                } while (menu != 0);
                            } else {
                                System.out.println("\u001b[38;5;196mAdmin is not found. Try again!\u001b[0m");
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                } while (!userIsFound);
            }
        } while (exitOrLog != 0);

    }

    private static void deleteProduct(TreeMap<String, Double> treeMap, Scanner scanner, RecommendedProducts recommendedProducts) {
        displayClass.displaySubCatalog(treeMap);
        System.out.print("\u001b[38;5;27mChoose a product: \u001b[0m");
        Map.Entry<String, Double> entry = user.get(scanner.nextInt(), treeMap);
        admin.deleteProduct(treeMap, entry.getKey());
        recommendedProducts.recProducts.remove(entry.getKey());
        FavouriteProducts.favouritesMap.remove(entry.getKey());
        Basket.basket.remove(entry.getKey());

    }


    private static boolean operationsWithProducts(Scanner scanner, TreeMap<String, Double> treeMap, String catalogName) {
        displayClass.displayNameOfTheCategory(catalogName);
        displayClass.displaySubCatalog(treeMap);
        System.out.print("\n\u001b[38;5;27mChoose the number of the product: \n\u001b[0m");
        return userFunctions(user.get(scanner.nextInt(), treeMap));
    }

    private static boolean userFunctions(Map.Entry<String, Double> entry) {
        if (entry == null) {
            System.out.println("\n\u001b[38;5;196mInvalid Value\n\u001b[0m");
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\u001b[38;5;27mAdd to favourites   ->  1");
        System.out.println("Add to the basket   ->  2\u001b[0m");
        int option = scanner.nextInt();
        if (option == 1) {
            user.addProductToFavouritesList(entry);
            System.out.println("\n\u001b[38;5;51mAdded!\u001b[0m");
            return true;
        } else if (option == 2) {
            user.order(entry);
            System.out.println("\n\u001b[38;5;51mAdded to basket\u001b[0m");
            return true;
        }
        return false;
    }

    private static boolean logIn(TreeMap<String, String> treeMap, String username, String password) {
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (entry.getKey().equals(username) && entry.getValue().equals(password))
                return true;
        }
        return false;
    }


}

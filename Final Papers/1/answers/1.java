import java.util.Scanner;

// a) FoodItem class
class FoodItem {
    // private attributes
    private String itemId;
    private String itemName;
    private double price;
    private int quantityAvailable;

    // b) Constructor
    public FoodItem(String itemId, String itemName, double price, int quantityAvailable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    // c) placeOrder method
    public void placeOrder(int units) {
        if (units > quantityAvailable) {
            System.out.println("Sorry, not enough stock. Please order fewer units or choose another item.");
        } else {
            quantityAvailable -= units;
            double totalPrice = units * price;
            System.out.println("Order placed successfully! Total price: Rs." + totalPrice);
        }
    }

    // d) displayItemDetails method
    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: Rs." + price);
        System.out.println("Quantity Available: " + quantityAvailable);
        System.out.println("");
    }

    // Getter
    public String getItemName() {
        return itemName;
    }
}

// e) FoodOrderApp class
class FoodOrderApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // I. Input details of two food items
        FoodItem[] items = new FoodItem[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for food item " + (i + 1) + ":");
            System.out.print("Item ID: ");
            String itemId = sc.nextLine();
            System.out.print("Item Name: ");
            String itemName = sc.nextLine();
            System.out.print("Price: Rs.");
            double price = sc.nextDouble();
            System.out.print("Quantity Available: ");
            int quantityAvailable = sc.nextInt();
            // Clear buffer
            sc.nextLine();

            items[i] = new FoodItem(itemId, itemName, price, quantityAvailable);
            System.out.println();
        }

        // II. Ask for order quantity and process order for each item
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter number of units to order for item '" + items[i].getItemName() + "': ");
            int units = sc.nextInt();
            items[i].placeOrder(units);
            System.out.println();
        }

        // III. Display details of both items after ordering
        System.out.println("Final details of food items after order:");
        for (FoodItem item : items) {
            item.displayItemDetails();
        }

        sc.close();
    }
}

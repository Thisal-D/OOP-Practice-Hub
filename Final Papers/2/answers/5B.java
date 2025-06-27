import java.util.ArrayList;

// 1. Interface: Storable
interface Storable {
    String getProductID();

    String getName();

    void displayDetails();
}

// 2. Product class implementing Storable
class Product implements Storable {
    private String productID;
    private String name;
    private double price;
    private static double discountRate;

    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getDiscountedPrice() {
        return price - (price * discountRate / 100);
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name      : " + name);
        System.out.println("Price     : $" + price);
        System.out.println("Discounted Price: $" + getDiscountedPrice());
        System.out.println("--------------------------");
    }

    public static void setDiscountRate(double rate) {
        discountRate = rate;
    }
}

// 3. Inventory class
class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void displayAllProducts() {
        System.out.println("Inventory Details");
        for (Product p : products) {
            p.displayDetails();
        }
    }
}

// 4. Main class
class Main {
    public static void main(String[] args) {
        // Set a common discount rate for all products
        Product.setDiscountRate(10.0); // 10% discount

        // Create product objects
        Product p1 = new Product("P101", "Laptop", 1200.0);
        Product p2 = new Product("P102", "Smartphone", 800.0);
        Product p3 = new Product("P103", "Headphones", 150.0);

        // Create inventory and add products
        Inventory inventory = new Inventory();
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        // Display all product details
        inventory.displayAllProducts();
    }
}

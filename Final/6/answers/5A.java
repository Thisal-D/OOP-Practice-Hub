class InvoicePrinter {
    public void printInvoice(Order order, TaxCalculator taxCalc, DiscountCalculator discountCalc) {
        double subtotal = order.getTotalAmount();
        double tax = taxCalc.calculateTax(subtotal);
        double discount = discountCalc.calculateDiscount(subtotal);
        double total = subtotal + tax - discount;

        System.out.println("=== INVOICE ===");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Items:");
        for (int i = 0; i < order.getItemCount(); i++) {
            System.out.println("- " + order.getItems()[i] + " ($" + order.getPrices()[i] + ")");
        }
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("Total: $%.2f%n", total);
    }
}

class DiscountCalculator {
    public double calculateDiscount(double amount) {
        if (amount > 100) {
            return amount * 0.05; // 5% discount
        }
        return 0;
    }
}

class TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.10; // 10% tax
    }
}

// Core Order class
class Order {
    private String orderId;
    private String customerName;
    private String[] items;
    private double[] prices;
    private int itemCount;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new String[10];
        this.prices = new double[10];
        this.itemCount = 0;
    }

    public void addItem(String item, double price) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String[] getItems() {
        return items;
    }

    public double[] getPrices() {
        return prices;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalAmount() {
        double sum = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += prices[i];
        }
        return sum;
    }
}

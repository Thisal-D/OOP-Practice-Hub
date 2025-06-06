import java.util.Scanner;

class VideoGame {
    private String gameId;
    private String title;
    private String platform;
    private int copiesInStock;

    // Constructor
    public VideoGame(String gameId, String title, String platform, int copiesInStock) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
        this.copiesInStock = copiesInStock;
    }

    // Method to rent game
    public void rentGame(int copiesRequested) {
        if (copiesRequested > copiesInStock) {
            System.out.println("Insufficient stock. Please try a smaller quantity or check back later.");
        } else {
            copiesInStock -= copiesRequested;
            System.out.println("Game rented successfully!");
        }
    }

    // Method to display game info
    public void displayGameInfo() {
        System.out.println("Game ID: " + gameId);
        System.out.println("Title: " + title);
        System.out.println("Platform: " + platform);
        System.out.println("Copies in Stock: " + copiesInStock);
        System.out.println("---------------------------------");
    }
}

class GameRentalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first game
        System.out.println("Enter details for Game 1:");
        System.out.print("Game ID: ");
        String id1 = scanner.nextLine();
        System.out.print("Title: ");
        String title1 = scanner.nextLine();
        System.out.print("Platform: ");
        String platform1 = scanner.nextLine();
        System.out.print("Copies in stock: ");
        int stock1 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        VideoGame game1 = new VideoGame(id1, title1, platform1, stock1);

        // Input for second game
        System.out.println("\nEnter details for Game 2:");
        System.out.print("Game ID: ");
        String id2 = scanner.nextLine();
        System.out.print("Title: ");
        String title2 = scanner.nextLine();
        System.out.print("Platform: ");
        String platform2 = scanner.nextLine();
        System.out.print("Copies in stock: ");
        int stock2 = scanner.nextInt();

        VideoGame game2 = new VideoGame(id2, title2, platform2, stock2);

        // Rental process for first game
        System.out.print("\nHow many copies of Game 1 would the customer like to rent? ");
        int rent1 = scanner.nextInt();
        game1.rentGame(rent1);

        // Rental process for second game
        System.out.print("\nHow many copies of Game 2 would the customer like to rent? ");
        int rent2 = scanner.nextInt();
        game2.rentGame(rent2);

        // Display final game info
        System.out.println("\n--- Game Details After Rental ---");
        game1.displayGameInfo();
        game2.displayGameInfo();

        scanner.close();
    }
}

import java.util.Scanner;

class CinemaApp {

    // MovieShow class defined inside the same file
    static class MovieShow {
        private String showId;
        private String movieTitle;
        private String showTime;
        private int seatsAvailable;

        // Constructor
        public MovieShow(String showId, String movieTitle, String showTime, int seatsAvailable) {
            this.showId = showId;
            this.movieTitle = movieTitle;
            this.showTime = showTime;
            this.seatsAvailable = seatsAvailable;
        }

        // Method to book tickets
        public void bookTickets(int seatsRequested) {
            if (seatsRequested > seatsAvailable) {
                System.out.println("Not enough seats available. Please select fewer seats or another show.");
            } else {
                seatsAvailable -= seatsRequested;
                System.out.println("Booking successful!");
            }
        }

        // Method to display show details
        public void displayShowDetails() {
            System.out.println("Show ID: " + showId);
            System.out.println("Movie Title: " + movieTitle);
            System.out.println("Show Time: " + showTime);
            System.out.println("Seats Available: " + seatsAvailable);
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details for the first show
        System.out.println("Enter details for Show 1:");
        System.out.print("Show ID: ");
        String id1 = scanner.nextLine();
        System.out.print("Movie Title: ");
        String title1 = scanner.nextLine();
        System.out.print("Show Time: ");
        String time1 = scanner.nextLine();
        System.out.print("Seats Available: ");
        int seats1 = scanner.nextInt();
        scanner.nextLine(); // consume newline

        MovieShow show1 = new MovieShow(id1, title1, time1, seats1);

        // Input details for the second show
        System.out.println("\nEnter details for Show 2:");
        System.out.print("Show ID: ");
        String id2 = scanner.nextLine();
        System.out.print("Movie Title: ");
        String title2 = scanner.nextLine();
        System.out.print("Show Time: ");
        String time2 = scanner.nextLine();
        System.out.print("Seats Available: ");
        int seats2 = scanner.nextInt();

        MovieShow show2 = new MovieShow(id2, title2, time2, seats2);

        // Booking for show 1
        System.out.print("\nHow many seats do you want to book for Show 1? ");
        int book1 = scanner.nextInt();
        show1.bookTickets(book1);

        // Booking for show 2
        System.out.print("How many seats do you want to book for Show 2? ");
        int book2 = scanner.nextInt();
        show2.bookTickets(book2);

        // Display final show details
        System.out.println("\nFinal Show Details:");
        show1.displayShowDetails();
        show2.displayShowDetails();

        scanner.close();
    }
}

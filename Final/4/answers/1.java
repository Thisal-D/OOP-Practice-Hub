import java.util.Scanner;

class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[3];

        // Input details for 3 books
        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");
            System.out.print("Book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Copies Available: ");
            int copies = scanner.nextInt();

            books[i] = new Book(id, title, author, copies);
        }

        // Borrow process
        for (int i = 0; i < books.length; i++) {
            System.out.print("Enter number of copies to borrow for Book " + (i + 1) + ": ");
            int borrow = scanner.nextInt();
            books[i].borrowBook(borrow);
        }

        // Return process for first book
        System.out.print("Enter number of copies to return for Book 1: ");
        int returnCopies = scanner.nextInt();
        books[0].returnBook(returnCopies);

        // Display final details
        System.out.println("\nFinal Book Details:");
        for (Book book : books) {
            book.displayBookDetails();
        }

        scanner.close();
    }
}

// Separate Book class in the same file (not public, and non-static)
class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private int copiesAvailable;

    // Constructor
    public Book(int bookId, String bookTitle, String author, int copiesAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Method to borrow books
    public void borrowBook(int copiesRequested) {
        if (copiesAvailable < copiesRequested) {
            System.out.println("Insufficient copies available. Please request fewer copies or try another book.");
        } else {
            copiesAvailable -= copiesRequested;
            System.out.println("Book borrowed successfully!");
        }
    }

    // Method to return books
    public void returnBook(int copiesReturned) {
        copiesAvailable += copiesReturned;
        System.out.println("Book returned successfully!");
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
        System.out.println("-----------------------------");
    }
}

package task3;

import java.util.ArrayList;
import java.util.Scanner;

// task3.Book Class
class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;


    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Books are available when created
    }


    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "task3.Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

// task3.Library Class
class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("task3.Book added successfully.");
    }

    // Method to remove a book by ID
    public boolean removeBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                books.remove(book);
                System.out.println("task3.Book removed successfully.");
                return true;
            }
        }
        System.out.println("task3.Book not found.");
        return false;
    }

    // Method to search for a book by ID
    public Book searchBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    // Method to display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

// Main Class
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Menu
        while (true) {
            System.out.println("\ntask3.Library System Menu:");
            System.out.println("1. Add a task3.Book");
            System.out.println("2. Remove a task3.Book");
            System.out.println("3. Search for a task3.Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a task3.Book
                    System.out.print("Enter task3.Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter task3.Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task3.Book Author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookID, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    // Remove a task3.Book
                    System.out.print("Enter task3.Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;

                case 3:
                    // Search for a task3.Book
                    System.out.print("Enter task3.Book ID to search: ");
                    int searchID = scanner.nextInt();
                    Book foundBook = library.searchBook(searchID);
                    if (foundBook != null) {
                        System.out.println("task3.Book Found: " + foundBook);
                    } else {
                        System.out.println("task3.Book not found.");
                    }
                    break;

                case 4:
                    // Display All Books
                    library.displayBooks();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting task3.Library System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

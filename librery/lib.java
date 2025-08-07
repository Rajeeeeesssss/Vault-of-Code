import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issue();
                System.out.println(user.getName() + " issued \"" + title + "\".");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println(user.getName() + " returned \"" + title + "\".");
                return;
            }
        }
        System.out.println("Book was not issued or doesn't exist.");
    }
}

public class lib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.print("Enter your name: ");
        User user = new User(sc.nextLine());

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Enter title of book to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle, user);
                    break;

                case 4:
                    System.out.print("Enter title of book to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle, user);
                    break;

                case 5:
                    System.out.println("Thank you for using the library system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

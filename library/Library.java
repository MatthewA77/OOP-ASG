import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Book added to library: " + book.title);
    }

    public void borrowBook(Borrower borrower, Book book) {
        for (Book cur : books) {
            if (cur == book) {
                borrower.borrowedBooks.add(cur);
                books.remove(cur);
                break;
            }
        }
        System.out.println("Alice borrowed: " + book.title);
    }

    public void returnBook(Borrower borrower, Book book) {
        for (Book cur : borrower.borrowedBooks) {
            if (cur == book) {
                books.add(cur);
                borrower.borrowedBooks.remove(cur);
                System.out.println("Alice returned: " + cur.title);
                break;
            }
        }
    }

    public void displayLibraryBooks() {
        System.out.println("Books in Library: ");
        for (Book cur : books) {
            System.out.println("Title: " + cur.title);
            System.out.println("ISBN: " + cur.ISBN);
            System.out.println("Author: " + cur.author.name);
            System.out.println("Biography: " + cur.author.desc);
            System.out.println("----------------------");
        }
    }
}
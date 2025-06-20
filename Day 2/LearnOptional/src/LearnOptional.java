import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private int rating;

    public Book(int id, String title, String author, int rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                '}';
    }
}

class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = Arrays.asList(
                new Book(1, "Java Basics", "Utkarsh", 75),
                new Book(2, "Spring Boot", "Mayur", 85),
                new Book(3, "Clean Code", "Robert", 60)
        );
    }

    public Optional<Book> findBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst(); // returns Optional<Book>
    }
}

public class LearnOptional {
    public static void main(String[] args) {
        BookRepository repo = new BookRepository();

        Optional<Book> foundBook = repo.findBookById(2);
        if (foundBook.isPresent()) {
            System.out.println("Found: " + foundBook.get());
        } else {
            System.out.println("Book not found");
        }

        Book result = repo.findBookById(10).orElse(new Book(0, "Not Found", "Unknown", 0));
        System.out.println("Using orElse: " + result.getTitle());

        repo.findBookById(3).ifPresent(b -> System.out.println("Author: " + b.getAuthor()));

        String title = repo.findBookById(1)
                .map(Book::getTitle)
                .orElse("No Title Found");
        System.out.println("Title fetched using map: " + title);
    }
}

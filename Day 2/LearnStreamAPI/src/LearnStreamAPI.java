import javax.swing.text.html.Option;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    int rating;

    public Book(int id, String title, String author, int rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

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



public class LearnStreamAPI {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Jack", "James", 9));
        bookList.add(new Book(2, "vinit", "abc", 4));
        bookList.add(new Book(3, "pranav", "lmn", 8));
        bookList.add(new Book(4, "lalu", "xyz", 7));

        bookList.stream()
                .filter(book -> book.getRating() > 5)
                .sorted(Comparator.comparing(book -> book.getTitle()))
                .map(book -> book.getTitle().toUpperCase())
                .forEach(System.out::println);







    }
}

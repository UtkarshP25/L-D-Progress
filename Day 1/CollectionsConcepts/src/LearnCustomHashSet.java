import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Books{
    String title;
    String author;

    Books(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(title, books.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LearnCustomHashSet {
    public static void main(String[] args) {

        Set<Books> booksSet = new HashSet<>();
        booksSet.add(new Books("Marvel", "Stan lee"));
        booksSet.add(new Books("spiderman", "Stan lee"));
        booksSet.add(new Books("bhagwatgeeta", "Shree krishna"));
        booksSet.add(new Books("bhagwatgeeta", "Shree krishna"));

        for (Books books : booksSet) {
            System.out.println(books);
        }

    }
}

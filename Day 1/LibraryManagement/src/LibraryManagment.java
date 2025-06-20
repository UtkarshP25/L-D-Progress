import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private int id;
    private String title;
    private String author;

    Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class Library{
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();

    void addBook(){

        System.out.println("Enter Book Title : ");
        String title = sc.nextLine();
        System.out.println("Enter Book Author : ");
        String author = sc.nextLine();
        System.out.println("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : bookList) {
            if (b.getId() == id) {
                System.out.println("Book ID already exists. Please enter a different ID.");
                return;
            }
        }

        bookList.add(new Book(id, title, author));

    }

    void removeBookById(int id) throws BookNotFound {
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getId() == id){
                bookList.remove(i);
                System.out.println("Book Removed successfully");
                return;
            }
        }
        throw new BookNotFound("Book Not Found");
    }

    void searchBookById(int id) throws BookNotFound{
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getId() == id){
                System.out.println(bookList.get(i));
                return;
            }
        }

        throw new BookNotFound("Book not found");
    }

    void displayAllBooks(){
        if(bookList.isEmpty()){
            System.out.println("Library is Empty");
            return;
        }
        for(Book book : bookList){
            System.out.println(book);
        }
    }

}


public class LibraryManagment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("1. Add Book");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Remove Book By ID");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 :
                    library.addBook();
                    break;

                case 2 :
                    try{
                        System.out.println("Enter Book ID : ");
                        library.searchBookById(sc.nextInt());
                    }catch(BookNotFound e){
                        System.out.println("Exception " + e.getMessage());

                    }
                    break;

                case 3 :
                    try{
                        System.out.println("Enter Book ID : ");
                        library.removeBookById(sc.nextInt());
                    }catch(BookNotFound e){
                        System.out.println("Exception " + e.getMessage());
                    }
                    break;

                case 4 :
                    library.displayAllBooks();
                    break;

                case 5 :
                    System.exit(0);

                default:
                    System.out.println("Wrong choice");

            }

        }

    }
}

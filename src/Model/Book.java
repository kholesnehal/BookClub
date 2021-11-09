package Model;
import java.util.List;

public class Book {
    public boolean borrowed;
    private String bookName;
    private String ISBN;
    public  List<String> authorName;
    private Owner owner;

    public Book(String bookName, String ISBN, List<String> authorName, Owner owner) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.owner = owner;

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", authorName=" + authorName +
                ", owner=" + owner +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

//    public static boolean byBookName(Book book) {
//        return this.getBookName().contains((CharSequence) book);
//
//    }
}
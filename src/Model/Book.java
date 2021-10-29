package Model;


import java.util.ArrayList;

public class Book {
    public boolean borrowed;
    //    private User user;
    private String bookName;
    private String ISBN;
    private ArrayList<String>authorName;
    private Owner owner;

    public Book(String bookName, String ISBN, ArrayList<String> authorName, Owner owner) {
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

    public ArrayList<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(ArrayList<String> authorName) {
        this.authorName = authorName;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}
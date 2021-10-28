package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookIssueDetails {
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String bookName;
    private User user;
    private ArrayList<Book> book;

    public BookIssueDetails(LocalDate issueDate, String bookName, User user) {
        this.issueDate = issueDate;
        this.bookName = bookName;
        this.user = user;
        this.book=book;
    }

    @Override
    public String toString() {
        return "BookIssueDetails{" +
                "issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", bookName='" + bookName + '\'' +
                ", user=" + user +
                '}';
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getBookName() {
        return bookName;
    }

    public User getUser() {
        return user;
    }

}

package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookIssueDetails {
    private LocalDate issueDate;
    private String returnDate;
    private String bookName;
    private User user;
    private ArrayList<Book> book;

//    public BookIssueDetails(LocalDate issueDate, String bookName, User user) {
//        this.issueDate = issueDate;
//        this.bookName = bookName;
//        this.user = user;
//        this.book=book;
//    }


    public BookIssueDetails(LocalDate issueDate, String returnDate, String bookName, User user) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.bookName = bookName;
        this.user = user;
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

    public String getReturnDate() {
        return returnDate;
    }

    public String getBookName() {
        return bookName;
    }

    public User getUser() {
        return user;
    }

}

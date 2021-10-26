package Model;

import java.time.LocalDate;

public class BookIssueDetails {
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String bookName;
    private User user;

    public BookIssueDetails(LocalDate issueDate, String bookName, User user) {
        this.issueDate = issueDate;
        this.bookName = bookName;
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookIssueDetails{" +
                "issueDate=" + issueDate +
                ", book=" + bookName +
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
//    public String getBookName() {
//        return ;
//    }
}

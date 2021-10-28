
package Dao;

import Model.Book;
import Model.BookIssueDetails;
import Model.User;


import java.time.LocalDate;
import java.util.*;

public class BookService {

    Scanner sc = new Scanner(System.in);
    List<Book> booklist = new ArrayList<>();
    List<Book> duplicatebooklist = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Book> borrowed = new ArrayList<Book>();
    List<Book> borrowedBook = new ArrayList<>();

    public void addBook() {
        System.out.println("Enter Book name : ");
        String bookName = sc.next();

        System.out.println("Enter ISBN : ");
        int ISBN = sc.nextInt();

        System.out.println("Enter price : ");
        float price = sc.nextFloat();

        System.out.println("Author name : ");
        String authorName = sc.next();

        Book b = new Book(bookName, ISBN, price, authorName);
        booklist.add(b);
        System.out.println("Book added successfully!!");
    }

    public void showBook() {
        System.out.println("Available books:");
        booklist.forEach(book -> System.out.println(book.toString()));
    }

    Map<Integer, ArrayList<BookIssueDetails>> hm = new HashMap<Integer, ArrayList<BookIssueDetails>>();
    ArrayList<BookIssueDetails> list = new ArrayList<>();

    public Book issuedBook() {
        System.out.println("Enter book name:");
        String title = sc.next();
        System.out.println("Enter a Borrower Name");
        String borrowername = sc.next();
        System.out.println("Enter a Borrower Mobile Number");
        long mobile = sc.nextLong();
        User u = new User(borrowername, mobile);
        userList.add(u);
        LocalDate issuedate = LocalDate.now();
        BookIssueDetails be = new BookIssueDetails(issuedate, title, u);
        list.add(be);
        System.out.println(list);

        Book select = null;
        int found = 0;
        for (Book b : booklist) {
            if (b.getBookName().equals(title)) {
                if (found == 0) {
                    select = b;
                    found = 1;
                    booklist.remove(b);
                    break;
                }
                return select;

            }

            if (!b.isBorrowed()) {
                b.borrowed = true;
                found = 2;
                break;
            }
        }

        if (found == 0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else if (found == 1) {
            System.out.println("You successfully borrowed " + title);
            borrowedBook.add(select);

        } else if (found == 2) {
            System.out.println(title + "already borrowed!");


        }
        return select;
    }

    public void requestBook() {
        int found = 0;
        System.out.println("Enter book name:");
        String bookname = sc.next();
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (booklist.contains(b.bookName())) {
                found = 1;
                System.out.println("Book is available");
            }
        }
        if (found == 0) {
            System.out.println("Book is occupied ! please wait.");
        }
    }

    public void byBookName() {
        System.out.println("Enter Book Name:");
        String nameOfBook = sc.next();
        int count = 0;
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (nameOfBook.equalsIgnoreCase(b.bookName())) {
                count = 1;
                System.out.println(b.toString());
                System.out.println("Book is available in catlogue");
            }
        }
        if (count == 0) {
            System.out.println("Book is not available in catlogue");
        }
    }

    public void byISBN() {
        int count = 0;
        System.out.println("Enter ISBN number : ");
        int ISBN = sc.nextInt();
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (ISBN == (b.getISBN())) {
                count = 1;
                System.out.println(b.toString());
                System.out.println("Book is available for" + ISBN);
            }

        }
        if (count == 0) {
            System.out.println(" Book is not available for" + ISBN);
        }
    }

    public void byAuthorName() {
        int count = 0;
        System.out.println("Enter author name  : ");
        String nameOfAuthor = sc.next();
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (nameOfAuthor.equalsIgnoreCase(b.authorName())) {
                count = 1;

                System.out.println(b.toString());
                System.out.println("Book available");
            }
        }
        if (count == 0) {
            System.out.println("Book not available");
        }
    }

    public void discontinueBook(int isbn) {
        boolean successful = false;
        for (int i = 0; i < booklist.size(); i++) {
            if ((int) booklist.get(i).getISBN() == isbn) {
                booklist.remove(i);
                System.out.println("Book remove successfully");
                successful = true;
            }
        }

        if (!successful) {
            System.out.println("Could not remove book isbn " + isbn);
        }
    }
    public void returnBook()
    {
        int found=0;
        System.out.println("Enter a BookName");
        String bookName = sc.next();
        Iterator<Book> itr=borrowedBook.iterator();
        while (itr.hasNext())
        {
            Book b=itr.next();
            if(bookName.equalsIgnoreCase(b.getBookName()))
                found=1;
                System.out.println("book return successfully ");
                booklist.add(b);
            }
        if(found==0)
        {
            System.out.println("not return yet");
        }
        }
    }




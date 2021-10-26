
package Dao;

import Model.Book;
import Model.BookIssueDetails;
import Model.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.text.ParseException;

public class BookService {

    Scanner sc = new Scanner(System.in);
    Map<Integer, BookIssueDetails> register = new HashMap<Integer, BookIssueDetails>();


    List<Book> booklist = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Book> borrowed = new ArrayList<Book>();

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

    public void issuedBook() {
        System.out.println("Enter a BookName");
        String bookName = sc.next();
        System.out.println("Enter a Borrower Name");
        String borrowername = sc.next();
        System.out.println("Enter a Borrower Mobile Number");
        long mobile = sc.nextLong();
        User u = new User(borrowername, mobile);
        userList.add(u);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//        System.out.println(java.time.LocalDate.now());
        LocalDate issuedate = LocalDate.now();
        BookIssueDetails be = new BookIssueDetails(issuedate, bookName, u);
        list.add(be);

        for (User x : userList) {
            if (bookName.equalsIgnoreCase(be.getBookName())) {
                register.put(1, be);
                register.forEach((key, value) -> {
                    System.out.println("" + register.get(1).toString());
                    System.out.println("Book is issued successfully!!");
                });

            } else {
                System.out.println("Book is already issued!");

            }
        }
    }

    public void searchbook() {
        System.out.println("You can search book by \n 1)Press 1 to search Book Name \n 2)Press 2 to search Book by ISBN \n 3)Press 3 to search book by Author Name");
        System.out.println("Enter your Choice : ");
        int option = sc.nextInt();
        if (option == 1) {

            System.out.println("Enter Book Name:");
            String nameOfBook = sc.next();
            int count= 0;
            Iterator<Book> itr=booklist.iterator();
            while(itr.hasNext())
            {
                Book b= itr.next();
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

        if (option == 2) {
            int count=0;
              System.out.println("Enter ISB number : ");
            int ISBN = sc.nextInt();
            Iterator<Book>itr=booklist.iterator();
            while (itr.hasNext())
            {
                Book b=itr.next();
                if (ISBN == (b.getISBN())) {
                    count=1;
                        System.out.println(b.toString());
                        System.out.println("Book is available for"+ISBN);
                    }

                }
            if(count==0)
            {
                System.out.println(" Book is not available for"+ISBN);
            }
            }

        if (option == 3) {
            int count = 0;
            System.out.println("Enter author name  : ");
            String nameOfAuthor = sc.next();
            Iterator<Book> itr = booklist.iterator();
            while (itr.hasNext())
            {
                Book b=itr.next();
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

    }


    public void returnBook() {
            System.out.println("Enter book name:");
            Scanner c = new Scanner(System.in);
            String bookName = c.next();
            System.out.println("Enter mobile number:");
            long mono =c.nextLong();
            List<BookIssueDetails> bd = hm.get(bookName);
            for (BookIssueDetails b : bd) {
                if (b.getBookName() == bookName) {
                    LocalDate issueDate = b.getIssueDate();
                    Date todayDate = new Date();

                    long diff = todayDate.getTime() - issueDate.getDayOfYear();

                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    System.out.println("return date:"+diffDays);

//                    if (diffDays > 10) {
//                        int fine = (int) (diffDays - 10);
//                        fine = fine * 10;
//                        System.out.println("Total Fine " + fine + " Rs.");
//                    }
                }
            }

        }
    }












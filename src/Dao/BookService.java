
package Dao;

import Model.Book;
import Model.BookIssueDetails;
import Model.User;
import java.time.LocalDate;
import java.util.*;
import org.apache.log4j.*;
public class BookService {

    private static Logger logger= LogManager.getLogger(BookService.class);
    Scanner sc = new Scanner(System.in);
    Map<String, ArrayList<Book>> bookmap = new HashMap<>();

    ArrayList<Book> booklist = new ArrayList<>();

    ArrayList<Book>borrowedBook=new ArrayList<>();

    Queue<String>bookqueue=new PriorityQueue<>() ;
        Map<String,BookIssueDetails>bookIssueDetailsMap=new HashMap<String, BookIssueDetails>() ;

        public void addBook(Book book) {
            booklist.add(book);
            bookmap.put(book.getBookName(), booklist);

        }

    public void showBook() {
//        logger.error("Available books:");
//        logger.info("book:");
        logger.trace("Exiting application.");


        booklist.forEach(book -> System.out.println(book.toString()));
    }
    public Book issuedBook(String title) {

        Book select = null;
        int found = 0;
        for (Book b : booklist) {
            if (b.getBookName().equals(title)) {
                if (found == 0) {
                    select = b;
                    found = 1;
                    booklist.remove(b);
                    borrowedBook.add(select);

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

            logger.error("Sorry, this book is not in our catalog.");
        } else if (found == 1) {
            logger.error("You successfully borrowed " + title);



        } else if (found == 2) {

            logger.error(title+" book already borrowed!!.");
        }
        return select;
    }
    public void requestBook(String bookTitle)
    {
        for(Book book:booklist)
        {
            if (!bookTitle.equalsIgnoreCase(book.getBookName())) {
                logger.error("Request for book "+bookTitle+ " placed successfully!!");

                bookqueue.add(book.getBookName());
                Iterator it = bookqueue.iterator();
                while ((it.hasNext())) {
                    System.out.println(it.next() + ",");
                }
            break;
            }
            else
            {
                logger.error("book is available ");

                break;
            }

        }


    }

    public void byBookName(String title) {

        int count = 0;
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (title.equalsIgnoreCase(b.getBookName()) )
            {
                count = 1;
                System.out.println(b.toString());
                logger.error("Book is available in catlogue");

            }
        }
        if (count == 0) {
            logger.error("Book is not available in catlogue");

        }
    }

    public void byISBN(String isbn)
    {
        int count = 0;
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (isbn.equalsIgnoreCase(b.getISBN())) {
                count = 1;
                System.out.println(b.toString());
                logger.error("Book is available for " + isbn);

            }

        }
        if (count == 0) {
            logger.error(" Book is not available for  " + isbn);

        }
    }

    public void byAuthorName(ArrayList<String> author,String authorname) {
        int count = 0;
        Iterator<String> itr = author.iterator();
        while (itr.hasNext()) {
            String b = itr.next();
            if (author.contains(authorname) )
            {
                count = 1;

                System.out.println(b.toString());
                logger.error("Book  available");

            }
        }
        if (count == 0) {
            logger.error("Book not available");

        }
    }

    public void discontinueBook(String isbn) {
        boolean successful = false;
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getISBN() == isbn) {
                booklist.remove(i);
                logger.error("Book remove successfully");

                successful = true;
            }
        }
        if (!successful) {
            logger.error("Could not remove book isbn " + isbn);

        }
    }
    public void returnBook(String bookname)
    {
        int found=0;
        Iterator<Book> itr=borrowedBook.iterator();
        while (itr.hasNext())
        {
            Book b=itr.next();
            if(bookname.equalsIgnoreCase(b.getBookName()))
                found=1;
            logger.error("book return successfully ");

                booklist.add(b);
            }
        if(found==0)
        {
            logger.error("not return yet");

        }
        }
    }





package Dao;

import Model.Book;
import Model.BookIssueDetails;
import Model.User;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import static com.perennial.Main.*;
import org.apache.log4j.*;

public class BookService {

    private static Logger logger = LogManager.getLogger(BookService.class);
    Scanner sc = new Scanner(System.in);
    static Map<String, Book> bookmap = new HashMap<>();

    static ArrayList<Book> booklist = new ArrayList<>();

    ArrayList<Book> borrowedBook = new ArrayList<>();

    Queue<String> bookqueue = new PriorityQueue<>();
//    Map<String, BookIssueDetails> bookIssueDetailsMap = new HashMap<String, BookIssueDetails>();

    public void addBook(Book book) {
        booklist.add(book);
        bookmap.put(book.getBookName(), book);


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

            logger.error(title + " book already borrowed!!.");
        }
        return select;
    }

    public void requestBook(String bookTitle) {
        for (Book book : booklist) {
            if (!bookTitle.equalsIgnoreCase(book.getBookName())) {
                logger.error("Request for book " + bookTitle + " placed successfully!!");

                bookqueue.add(book.getBookName());
                Iterator it = bookqueue.iterator();
                while ((it.hasNext())) {
                    System.out.println(it.next() + ",");
                }
                break;
            } else {
                logger.error("book is available ");

                break;
            }

        }


    }

    public List<Book> byBookName(String title) {
        List<Book> bookwithName = booklist.stream().filter(p -> p.getBookName().contains(title)).collect(Collectors.toList());
        System.out.println(bookwithName);

        return bookwithName;



    }



    public List<Book> byISBN(String isbn) {
        List<Book> bookwithName = booklist.stream().filter(p -> p.getBookName().contains(isbn)).collect(Collectors.toList());
        System.out.println(bookwithName);


        return bookwithName;


    }

    public static void searchAuthorName(List<String> searchAuthorName) {
        int n = authorName.size();
        Map<String, Book> sb = bookmap.entrySet().stream().filter(e -> e.getValue().authorName.get(n).contains(searchAuthorName.get(n))).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        {

            sb.forEach((key, value) -> {
                logger.error(key + " " + sb.get(key).getBookName() + " " + sb.get(key).getISBN() + " " + sb.get(key).getAuthorName() + " " + sb.get(key).authorName);
            });
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
            if(bookname.contains(b.getBookName()))
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





package Dao;

import Model.Book;
import Model.BookIssueDetails;
import Model.User;


import java.time.LocalDate;
import java.util.*;

public class BookService {

    Scanner sc = new Scanner(System.in);
    Map<String, ArrayList<Book>> bookData = new HashMap<>();

    ArrayList<Book> booklist = new ArrayList<>();

    ArrayList<String>authors=new ArrayList<>();



        public void addBook(Book book) {
            booklist.add(book);
            bookData.put(book.getBookName(), booklist);

        }


    public void showBook() {
        System.out.println("Available books:");
       booklist.forEach(book -> System.out.println(book.toString()));
    }

//
//
//
    public Book issuedBook(BookIssueDetails bookIssueDetails,String title) {

        Book select = null;
        int found = 0;
        for (Book b : booklist) {
            if (b.getBookName().equals(title)) {
                if (found == 0) {
                    select = b;
                    found = 1;
                    booklist.remove(b);
//                    borrowedBook.add(select);
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
            System.out.println(title+" already borrowed !!");
        } else if (found == 1) {
            System.out.println("You successfully borrowed " + title);
//            borrowedBook.add(select);

        } else if (found == 2) {
            System.out.println("Sorry, this book is not in our catalog.");


        }
        return select;
    }

//    public void requestBook() {
//        int found = 0;
//        System.out.println("Enter book name:");
//        String bookname = sc.next();
//        Iterator<Book> itr = borrowedBook.iterator();
//        while (itr.hasNext()) {
//            Book b = itr.next();
//            if (borrowedBook.contains(b.bookName())) {
//                found = 1;
//                System.out.println("Book is available");
//            }
//        }
//        if (found == 0) {
//            System.out.println("Book is occupied ! please wait.");
//        }
//    }
//
    public void byBookName(String title) {

        int count = 0;
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (title.equalsIgnoreCase(b.getBookName()) )
            {
                count = 1;
                System.out.println(b.toString());
                System.out.println("Book is available in catlogue");
            }
        }
        if (count == 0) {
            System.out.println("Book is not available in catlogue");
        }
    }
//
    public void byISBN(String isbn)
    {
        int count = 0;
        Iterator<Book> itr = booklist.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            if (isbn.equalsIgnoreCase(b.getISBN())) {
                count = 1;
                System.out.println(b.toString());
                System.out.println("Book is available for " + isbn);
            }

        }
        if (count == 0) {
            System.out.println(" Book is not available for  " + isbn);
        }
    }

    public void byAuthorName(ArrayList<String> author,String authorname) {
        int count = 0;
        Iterator<String> itr = author.iterator();
        while (itr.hasNext()) {
            String b = itr.next();
            if (authorname.contains(b) )
            {
                count = 1;

                System.out.println(b.toString());
                System.out.println("Book available");
            }
        }
        if (count == 0) {
            System.out.println("Book not available");
        }
    }

    public void discontinueBook(String isbn) {
        boolean successful = false;
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getISBN() == isbn) {
                booklist.remove(i);
                System.out.println("Book remove successfully");
                successful = true;
            }
        }
        if (!successful) {
            System.out.println("Could not remove book isbn " + isbn);
        }
    }
//    public void returnBook()
//    {
//        int found=0;
//        System.out.println("Enter a BookName");
//        String bookName = sc.next();
//        Iterator<Book> itr=borrowedBook.iterator();
//        while (itr.hasNext())
//        {
//            Book b=itr.next();
//            if(bookName.equalsIgnoreCase(b.getBookName()))
//                found=1;
//                System.out.println("book return successfully ");
//                booklist.add(b);
//            }
//        if(found==0)
//        {
//            System.out.println("not return yet");
//        }
//        }
    }




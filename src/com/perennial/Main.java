package com.perennial;

import Dao.BookService;
import Model.Book;
import Model.BookIssueDetails;
import Model.Owner;
import Model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
public class Main {
    BookService bookService = new BookService();

        public void entryData() throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("**********   Welcome to BookStore  ************");
        Scanner in = new Scanner(System.in);
        System.out.println("1)Add Book ");
        System.out.println("2)Show Book");
        System.out.println("3)Search Book");
        System.out.println("4)Issue Book");
        System.out.println("5)Request Book");
        System.out.println("6)Return Book");
        System.out.println("7)Discontinue Book");
        System.out.println("8)Exit");
        int option = in.nextInt();

            String returndate="";
        ArrayList<String> authors = new ArrayList<>();
        switch (option) {
//
            case 1:
//
                System.out.println("Enter Book name : ");
                String bookName = sc.nextLine();

                System.out.println("Enter ISBN : ");
                String isbn = sc.nextLine();

                System.out.println(" Enter Author names separated by(,) : ");
                String authorName = sc.next();
                System.out.println("Enter Owner name:");
                String ownername = sc.next();
                System.out.println("Enter Owner Address:");
                String address = sc.next();
                System.out.println("Enter Owner mobile number:");
                long ownerMoNo = sc.nextLong();
                Owner owner = new Owner(ownername, address, ownerMoNo);

                String[] array = authorName.split(",");
                HashSet<String> authorSet = new HashSet<>(Arrays.asList(array));
                String[] authorsArray = authorSet.toArray(new String[0]);
                authors.addAll(authorSet);

                Book book = new Book(bookName, isbn, authors, owner);
                bookService.addBook(book);
                System.out.println("Book added successfully...");
                entryData();
                break;
            case 2:
                bookService.showBook();
                entryData();
                break;

            case 3:
                System.out.println("You can search book by..." + "\n" + "1)Press 1 to search book by book name" + "\n" + "2)Press 2 search book by ISBN" + "\n" + "3)Press 3 search book by author name");
                System.out.println("Enter your choice:");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Enter book name:");
                        String bookname = sc.next();
                        bookService.byBookName(bookname);
                        entryData();
                        break;
                    case 2:
                        System.out.println("Enter ISBN: ");
                        String isbn1 = sc.next();
                        bookService.byISBN(isbn1);
                        entryData();
                        break;
                    case 3:

                        System.out.println("Enter author name:");
                        String authorname = sc.next();
                        bookService.byAuthorName(authors, authorname);
                        entryData();
                        break;
                }
                break;

            case 4:
                System.out.println("Enter book name:");
                String title = sc.next();
                System.out.println("Enter user Name");
                String username = sc.next();
                System.out.println("Enter User address:");
                String userAddress = sc.next();
                System.out.println("Enter user Mobile Number");
                long mobile = sc.nextLong();

                User user = new User(username, userAddress, mobile);

                LocalDate issueDate = LocalDate.now();
                BookIssueDetails bookIssueDetails=new BookIssueDetails(issueDate,returndate,title,user);
                System.out.println(bookIssueDetails);
                bookService.issuedBook(title);
                entryData();
                break;
            case 5:
                System.out.println("Enter book name:");
                String bname = sc.next();
                bookService.requestBook(bname);
                entryData();
                break;

            case 6:
                System.out.println("Enter book name:");
                String bookname= sc.next();
                System.out.println("Enter return date in format(dd-mm-yyyy)");

                returndate = sc.next();
                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(returndate);
                System.out.println(date1);

                bookService.returnBook(bookname);
                entryData();
                break;
            case 7:
                System.out.println("Enter ISBN:");
                String isbn2 = sc.next();
                bookService.discontinueBook(isbn2);
                entryData();
                break;

            case 8:
                System.exit(0);
                break;

            default:
                System.out.println("Please enter valid input");


        }


    }

        public static void main (String[]args) throws ParseException {
            Main main = new Main();
            main.entryData();

        }
    }


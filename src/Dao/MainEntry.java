package Dao;

import Model.User;

import java.util.Scanner;

public class MainEntry {
    BookService bookService=new BookService();

    public void entryData()
    {
              Scanner sc=new Scanner(System.in);


        System.out.println("****************     WELCOME TO BOOKSTORE APP    ******************");
        System.out.println("Search:"+"\n"+"1)Add Book"+"\n"+"2)See all Book"+"\n"+"3)Search Book"+"\n"+"4)Issue Book"+"\n"+"5)Return Book"+"\n"+"6)Discontinue Book"+"\n"+"7)Request book"+"\n"+"8)Exit");
        System.out.println("Enter your choice:");
        Integer choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                int n1=1;
                while (n1==1) {
                    bookService.addBook();
//                    entryData();
                    System.out.println("Do you want to add more book ?"+"\n"+"For YES press 1"+"\n"+"For NO press 0");
                    n1 = sc.nextInt();
//                entryData();

                }
                entryData();
            break;
            case 2:
                bookService.showBook();
            entryData();
                break;

            case 3:
                System.out.println("You can search book by..."+"\n"+"1)Press 1 to search book by book name"+"\n"+"2)Press 2 search book by ISBN"+"\n"+"3)Press 3 search book by author name");
                System.out.println("Enter your choice:");
                int option=sc.nextInt();
                switch (option) {
                    case 1:
                        bookService.byBookName();
                        entryData();
                        break;
                    case 2:
                        bookService.byISBN();
                        entryData();
                        break;
                    case 3:
                        bookService.byAuthorName();
                        entryData();
                        break;
                }
                break;
            case 4:bookService.issuedBook();
            entryData();
            break;

            case 5:bookService.returnBook();
            entryData();
            break;

            case 6:
                System.out.println("Enter ISBN:");
                int isbn=sc.nextInt();
                bookService.discontinueBook(isbn);
                entryData();
                break;
            case 7:
                bookService.requestBook();
                entryData();
                break;
            case 8:
                System.exit(0);
                break;

            default:
                System.out.println("Please enter valid input");

        }
    }

}

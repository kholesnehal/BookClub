package Dao;

import Model.User;

import java.util.Scanner;

public class MainEntry {
    BookService bookService=new BookService();

    public void entryData()
    {
              Scanner sc=new Scanner(System.in);


        System.out.println("****************     WELCOME TO BOOKSTORE APP    ******************");
        System.out.println("Search:"+"\n"+"1)Add Book"+"\n"+"2)See all Book"+"\n"+"3)Search Book"+"\n"+"4)Issue Book"+"\n"+"5)Return Book"+"\n"+"6)Discontinue Book"+"\n"+"7)Request Book"+"\n"+"8)Exit");
        System.out.println("Enter your choice:");
        Integer choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                int n1=1;
                while (n1 == 1) {
                    bookService.addBook();

                    System.out.println("Do you want to add more book ?"+"\n"+"For YES press 1"+"\n"+"For NO press 0");
                    n1 = sc.nextInt();
                    System.out.println();


                }
                entryData();
                break;
            case 2:
                bookService.showBook();
            entryData();
                break;

            case 3:
                int n2=1;
                while (n2==1) {
                    System.out.println("You can search book by \n 1)Press 1 to search Book Name \n 2)Press 2 to search Book by ISBN \n 3)Press 3 to search book by Author Name");
                    System.out.println("Enter your Choice : ");
                    int option = sc.nextInt();
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
                    System.out.println("Do you want to add more book ?"+"\n"+"For YES press 1"+"\n"+"For NO press 0");
                    n2 = sc.nextInt();
                    System.out.println();

                }
           break;

            case 4:bookService.issuedBook();
            entryData();
            break;

            case 5:
//                System.out.println("Enter issued Date:");
//            String issuedate=sc.next();
//            System.out.println("Enter return date:");
//            String returndate=sc.next();
//                String issuedate
//                        = "10-01-2018 01:10:20";
//                String returndate
//                        = "10-06-2020 06:30:50";


                bookService.returnBook();
            entryData();
            break;

            case 6:
                System.out.println("Enter ISBN number:");
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
            default:
                System.out.println("Invalid input");
                break;

                   }


    }

}

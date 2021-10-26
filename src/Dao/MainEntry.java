package Dao;

import Model.User;

import java.util.Scanner;

public class MainEntry {
    BookService bookService=new BookService();

    public void entryData()
    {
              Scanner sc=new Scanner(System.in);


        System.out.println("****************     WELCOME TO BOOKSTORE APP    ******************");
        System.out.println("Search:"+"\n"+"1)Add Book"+"\n"+"2)See all Book"+"\n"+"3)Search Book"+"\n"+"4)Issue Book"+"\n"+"5)Return Book"+"\n"+"6)Discontinue Book"+"\n"+"7)borrow");
        System.out.println("Enter your choice:");
        Integer choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                bookService.addBook();
                entryData();
                break;


            case 2:
                bookService.showBook();
            entryData();
                break;

            case 3:
                bookService.searchbook();
                entryData();
                break;

            case 4:bookService.issuedBook();
            entryData();
            break;

            case 5:bookService.returnBook();
            entryData();
            break;

            case 7:
                System.out.println("enter book name: ");
                String bname=sc.next();
                bookService.borrowBook(bname);
                entryData();
                break;
        }
    }

}

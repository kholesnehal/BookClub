package Model;

import java.util.ArrayList;

public class Book {
        private User user;
        private String bookName;
        private int ISBN;
        private float price;
        private String authorName;

        public Book(String bookName, int ISBN, float price, String authorName) {
//            this.user = user;
            this.bookName = bookName;
            this.ISBN = ISBN;
            this.price = price;
            this.authorName = authorName;
        }

        @Override
        public String toString() {
            return "Book{" +
//                    "user=" + user +
                    ", bookName='" + bookName + '\'' +
                    ", ISBN=" + ISBN +
                    ", price=" + price +
                    ", authorName=" + authorName +
                    '}';
        }

        boolean borrowed;
        public boolean isBorrowed()
        {
            return borrowed;
        }
        public User getUser() {
            return user;
        }

        public String getBookName() {
            return bookName;
        }

        public int getISBN() {
            return ISBN;
        }

        public float getPrice() {
            return price;
        }

        public String getAuthorName() {
            return authorName;
        }
    public String bookName() {return bookName;}
    public int ISBN() {return ISBN;}
    public String authorName() {return authorName;}

    }
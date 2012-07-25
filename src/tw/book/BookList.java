package tw.book;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private static BookList bookList;
    private static List<Book> books;

    private BookList() {
        books = new ArrayList<Book>();
        String booknamePrefix = "Book_";
        for(int i = 1; i<6;i++){
            Book book = new Book(booknamePrefix+i);
            books.add(book);
        }
    }

    public static BookList getInstance() {
        if (bookList == null) bookList = new BookList();
        return bookList;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isBookInList(String book) {
        return isBookInList(new Book(book));
    }

    public boolean isBookInList(Book book) {
        if (books.contains(book))
            return true;
        return false;
    }
}

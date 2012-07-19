package tw.main;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private static BookList bookList;
    private static List<String> books;

    private BookList() {
        books = new ArrayList<String>();
        books.add("Book_1");
        books.add("Book_2");
        books.add("Book_3");
        books.add("Book_4");
        books.add("Book_5");
    }

    public static BookList getInstance() {
        if (bookList == null) bookList = new BookList();
        return bookList;
    }

    public List<String> getBooks() {
        return books;
    }

    public boolean isBookInList(String book) {
        if (books.contains(book))
            return true;
        return false;
    }
}

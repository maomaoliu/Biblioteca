package tw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: noam
 * Date: 12-7-12
 * Time: 上午12:04
 * To change this template use File | Settings | File Templates.
 */
public class BookList {

    private static BookList bookList;
    private static List<String> books;

    private BookList(){
        books = new ArrayList<String>();
        books.add("Book_1");
        books.add("Book_2");
        books.add("Book_3");
        books.add("Book_4");
        books.add("Book_5");
    }

    public static BookList getInstance(){
        if(bookList==null) bookList = new BookList();
        return bookList;
    }

    public List<String> getBooks(){
        return books;
    }
}

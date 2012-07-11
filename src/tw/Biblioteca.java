package tw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: noam
 * Date: 12-7-11
 * Time: 下午10:09
 * To change this template use File | Settings | File Templates.
 */
public class Biblioteca {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.showWelcome());
    }

    public String showWelcome(){
        return "Welcome customer!";
    }

    public List<String> showMenuList() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("1. View books in library.");
        menuList.add("2. Check library number.");
        return menuList;
    }

    public MenuOption selectMenuOption(int i) {
        switch(i){
        case 1: return MenuOption.ViewBooks;
        case 2: return MenuOption.CheckLibNumber;
        }
        return MenuOption.Error;
    }

    public String showErrorMessage() {
        return "Select a valid option!!";
    }

    public List<String> showBooks() {
        return BookList.getInstance().getBooks();
    }

    public String reserveBook(String bookName) {
        if(BookList.getInstance().getBooks().contains(bookName))
        return "Thank You! Enjoy the book.";
        return "Sorry we don't have that book yet.";
    }

    public String checkNumber() {
        return "Please talk to Librarian. Thank you.";
    }
}

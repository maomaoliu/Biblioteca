package tw.main;

import java.io.Console;
import java.util.List;

public class BookAction {
    public void showBooks() {
        PrintTools.printlnWithStars();
        PrintTools.printlnWithStar("BOOK LIST");
        for (String book : getBooks())
            PrintTools.printlnWithStar(book);
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("Input BOOK NAME to reserve books.");
        PrintTools.printlnWithStar("Input 'TOMENU' to return to menu.");
        PrintTools.printlnWithStars();
    }

    public void action() {
        showBooks();
        Console console = System.console();
        String input = console.readLine();
        while (!this.judgeForToMenu(input)) {
            PrintTools.println(reserveBook(input));
            input = console.readLine();
        }
    }

    public List<String> getBooks() {
        return BookList.getInstance().getBooks();
    }

    public String reserveBook(String bookName) {
        if (BookList.getInstance().isBookInList(bookName))
            return "Thank You! Enjoy the book.";
        return "Sorry we don't have that book yet.";
    }

    public boolean judgeForToMenu(String input) {
        return input.toLowerCase().equals("tomenu");
    }
}

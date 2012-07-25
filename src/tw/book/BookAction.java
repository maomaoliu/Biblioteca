package tw.book;

import tw.uitools.InputTools;
import tw.uitools.PrintTools;

import java.util.List;

public class BookAction {
    public void showBooks() {
        PrintTools.printlnWithStars();
        PrintTools.printlnWithStar("BOOK LIST");
        for (Book book : getBooks())
            PrintTools.printlnWithStar(book.toString());
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("Input BOOK NAME to reserve books.");
        PrintTools.printlnWithStar("Input 'TOMENU' to return to menu.");
        PrintTools.printlnWithStars();
    }

    public void action() {
        showBooks();
        String input = InputTools.getLine();
        while (!this.judgeForToMenu(input)) {
            PrintTools.println(reserveBook(input));
            input = InputTools.getLine();
        }
    }

    public List<Book> getBooks() {
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

package tw.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: noam
 * Date: 12-7-11
 * Time: 下午10:09
 * To change this template use File | Settings | File Templates.
 */
public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.showWelcomeAndMenu();
        Scanner scanner = new Scanner(System.in);
        biblioteca.userAction(scanner);
    }


    public int handleInputNumber(String input) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        }
        return inputNumber;
    }

    public String readInput(Scanner scanner) {
        String input = scanner.nextLine();
        this.judgeForQuitAndDoIt(input);
        return input;
    }

    public boolean judgeForToMenu(String input) {
        return input.toLowerCase().equals("tomenu");
    }

    public void judgeForQuitAndDoIt(String input) {
        if (input.toLowerCase().equals("quit")) {
            System.out.println("Bye, wait for a moment ....");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.exit(0);
        }
    }

    public void showBooks() {
        PrintTools.printlnWithStars();
        PrintTools.printlnWithStar(showWelcome());
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("BOOK LIST");
        for (String book : getBooks())
            PrintTools.printlnWithStar(book);
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("Input BOOK NAME to reserve books.");
        PrintTools.printlnWithStar("Input 'TOMENU' to return to menu.");
        PrintTools.printlnWithStars();
    }

    public void bookAction(Scanner scanner) {
        String input;
        input = this.readInput(scanner);
        while (!this.judgeForToMenu(input)) {
            System.out.println(reserveBook(input));
            input = this.readInput(scanner);
        }
    }

    public void userAction(Scanner scanner) {
        String input = this.readInput(scanner);
        while (true) {
            int inputNumber = this.handleInputNumber(input);
            MenuOption menuOption = this.selectMenuOption(inputNumber);
            if (menuOption.equals(MenuOption.ViewBooks)) {
                this.showBooks();
                this.bookAction(scanner);
                this.showWelcomeAndMenu();
            } else if (menuOption.equals(MenuOption.CheckLibNumber)) {
                System.out.println(checkNumber());
            }else if(menuOption.equals(MenuOption.ViewMovies)){
                System.out.println("MOVIE LIST");
                System.out.println(this.showMovies());
                System.out.println("Input ENTER to return to menu.");
                this.readInput(scanner);
                this.showWelcomeAndMenu();
            } else {
                System.out.println(showErrorMessage());
            }
            input = this.readInput(scanner);
        }
    }

    public void showWelcomeAndMenu() {
        PrintTools.printlnWithStars();
        PrintTools.printlnWithStar(showWelcome());
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("MENU");
        for (String menuItem : getMenuList())
            PrintTools.printlnWithStar(menuItem);
        PrintTools.printlnWithStar(" ");
        PrintTools.printlnWithStar("Input NUMBER to choose menu options.");
        PrintTools.printlnWithStar("Input 'QUIT' to terminate.");
        PrintTools.printlnWithStars();
    }

    public String showWelcome() {
        return "Welcome customer!";
    }

    public List<String> getMenuList() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("1. View books in library.");
        menuList.add("2. Check library number.");
        menuList.add("3. View movies in library.");
        return menuList;
    }

    public MenuOption selectMenuOption(int i) {
        switch (i) {
            case 1:
                return MenuOption.ViewBooks;
            case 2:
                return MenuOption.CheckLibNumber;
            case 3:
                return MenuOption.ViewMovies;
        }
        return MenuOption.Error;
    }

    public String showErrorMessage() {
        return "Select a valid option!!";
    }

    public List<String> getBooks() {
        return BookList.getInstance().getBooks();
    }

    public String reserveBook(String bookName) {
        if (BookList.getInstance().isBookInList(bookName))
            return "Thank You! Enjoy the book.";
        return "Sorry we don't have that book yet.";
    }

    public String checkNumber() {
        return "Please talk to Librarian. Thank you.";
    }

    public String showMovies() {
        return "Movie name\tDirector\tRating\n"+MovieList.getInstance().getListString();
    }
}

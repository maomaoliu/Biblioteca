package tw;

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
        showWelcomeAndMenu(biblioteca);
        Scanner scanner = new Scanner(System.in);
        userAction(biblioteca, scanner);
    }

    public static void showWelcomeAndMenu(Biblioteca biblioteca) {
        printlnWithStars();
        printlnWithStar(biblioteca.showWelcome());
        printlnWithStar(" ");
        printlnWithStar("MENU");
        for (String menuItem : biblioteca.getMenuList())
             printlnWithStar(menuItem);
        printlnWithStar(" ");
        printlnWithStar("Input NUMBER to choose menu options.");
        printlnWithStar("Input 'QUIT' to terminate.");
        printlnWithStars();
    }

    private static void printlnWithStars() {
        for (int i = 0; i < 42; i++)
            System.out.print("*");
        System.out.println();
    }

    private static void printlnWithStar(String string) {

        System.out.print("*  ");
        System.out.printf("%-36s", string);
        System.out.println("  *");

    }


    public static void userAction(Biblioteca biblioteca, Scanner scanner) {
        String input = readInput(scanner);
        while (true) {
            int inputNumber = handleInputNumber(input);
            MenuOption menuOption = biblioteca.selectMenuOption(inputNumber);
            if (menuOption.equals(MenuOption.ViewBooks)) {
                showBooks(biblioteca);
                bookAction(biblioteca, scanner);
                showWelcomeAndMenu(biblioteca);
            } else if (menuOption.equals(MenuOption.CheckLibNumber)) {
                System.out.println(biblioteca.checkNumber());
            } else {
                System.out.println(biblioteca.showErrorMessage());
            }
            input = readInput(scanner);
        }
    }

    public static void showBooks(Biblioteca biblioteca) {
        printlnWithStars();
        printlnWithStar(biblioteca.showWelcome());
        printlnWithStar(" ");
        printlnWithStar("BOOK LIST");
        for (String book : biblioteca.getBooks())
            printlnWithStar(book);
        printlnWithStar(" ");
        printlnWithStar("Input BOOK NAME to reserve books.");
        printlnWithStar("Input 'TOMENU' to return to menu.");
        printlnWithStars();
    }

    private static void bookAction(Biblioteca biblioteca, Scanner scanner) {
        String input;
        input = readInput(scanner);
        while (!judgeForToMenu(input)) {
            System.out.println(biblioteca.reserveBook(input));
            input = readInput(scanner);
        }
    }

    public static int handleInputNumber(String input) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        }
        return inputNumber;
    }

    public static String readInput(Scanner scanner) {
        String input = scanner.nextLine();
        judgeForQuitAndDoIt(input);
        return input;
    }

    public static boolean judgeForToMenu(String input) {
        return input.toLowerCase().equals("tomenu");
    }

    public static void judgeForQuitAndDoIt(String input) {
        if (input.toLowerCase().equals("quit")) {
            System.out.println("Bey bey, wait for a moment ....");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.exit(0);
        }
    }

    public String showWelcome() {
        return "Welcome customer!";
    }

    public List<String> getMenuList() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("1. View books in library.");
        menuList.add("2. Check library number.");
        return menuList;
    }

    public MenuOption selectMenuOption(int i) {
        switch (i) {
            case 1:
                return MenuOption.ViewBooks;
            case 2:
                return MenuOption.CheckLibNumber;
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
        if (BookList.getInstance().getBooks().contains(bookName))
            return "Thank You! Enjoy the book.";
        return "Sorry we don't have that book yet.";
    }

    public String checkNumber() {
        return "Please talk to Librarian. Thank you.";
    }
}

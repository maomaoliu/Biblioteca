package tw.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private String username = null;

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.showWelcomeAndMenu();
        Scanner scanner = new Scanner(System.in);
        biblioteca.userAction(scanner);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String readInput(Scanner scanner) {
        String input = scanner.nextLine();
        this.judgeForQuitAndDoIt(input);
        return input;
    }

    public void judgeForQuitAndDoIt(String input) {
        if (input.toLowerCase().equals("quit")) {
            PrintTools.println("Bye, wait for a moment ....");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.exit(0);
        }
    }

    public void userAction(Scanner scanner) {
        String input = this.readInput(scanner);
        while (true) {
            MenuOption menuOption = this.selectMenuOption(input);
            if (menuOption.equals(MenuOption.ViewBooks)) {
                BookAction action = new BookAction();
                action.action();
                this.showWelcomeAndMenu();
            } else if (menuOption.equals(MenuOption.CheckLibNumber)) {
                PrintTools.println(checkNumber());
            } else if (menuOption.equals(MenuOption.ViewMovies)) {
                MovieAction action = new MovieAction();
                action.action();
                this.showWelcomeAndMenu();
            } else if (menuOption.equals(MenuOption.Login)) {
                LoginAction action = new LoginAction();
                action.action();
                this.username = action.getUsername();
                this.showWelcomeAndMenu();
            } else {
                PrintTools.println(showErrorMessage());
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
        if (this.getUsername() == null)
            PrintTools.printlnWithStar("Input LOGIN to log in.");
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

    public MenuOption selectMenuOption(String selection) {
        if (selection.equals("1"))
            return MenuOption.ViewBooks;
        if (selection.equals("2"))
            return MenuOption.CheckLibNumber;
        if (selection.equals("3"))
            return MenuOption.ViewMovies;
        if (selection.toLowerCase().equals("login"))
            return MenuOption.Login;
        return MenuOption.Error;
    }

    public String showErrorMessage() {
        return "Select a valid option!!";
    }

    public String checkNumber() {
        if (username == null)
            return "Please talk to Librarian. Thank you.";
        else return "Number is: " + this.getUsername();
    }
}

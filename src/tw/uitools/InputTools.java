package tw.uitools;

import java.io.Console;
import java.util.Scanner;

public class InputTools {

    private static Object input;

    static {
        Console console = System.console();
        if (console != null)
            input = console;
        else input = new Scanner(System.in);
    }

    public static String getLine() {
        if (input.getClass().equals(Console.class)) {
            return ((Console) input).readLine();
        } else {
            return ((Scanner) input).nextLine();
        }
    }

    public static String getPassword() {
        if (input.getClass().equals(Console.class)) {
            char[] password = ((Console) input).readPassword();
            return new String(password);
        } else {
            return ((Scanner) input).nextLine();
        }
    }
}

package tw.uitools;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.Logger;

/*
 * Are there tests for this class?
 *
 * Please write unit tests for this class.
 *
 */
public class InputTools {

    private static Logger LOGGER = Logger.getLogger(InputTools.class.getCanonicalName());

    private static Object input;

    /*
     * Why do you use two different ways to capture input?
     *
     * Is the code readable?
     *
     */
    static {
        Console console = System.console();
        if (console != null) {
            LOGGER.info("using console to capture input");
            input = console;
        }
        else {
            LOGGER.info("using scanner to capture input");
            input = new Scanner(System.in);
        }
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

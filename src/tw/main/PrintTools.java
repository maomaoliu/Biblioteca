package tw.main;

public class PrintTools {
    public static void printlnWithStars() {
        for (int i = 0; i < 42; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void printlnWithStar(String string) {
        System.out.print("*  ");
        System.out.printf("%-36s", string);
        System.out.println("  *");
    }
}
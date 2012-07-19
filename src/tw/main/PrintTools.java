package tw.main;

public class PrintTools {
    public static void printlnWithStars() {
        for (int i = 0; i < 42; i++)
            System.out.print("*");
        PrintTools.println(" ");
    }

    public static void printlnWithStar(String string) {
        System.out.print("*  ");
        System.out.printf("%-36s", string);
        PrintTools.println("  *");
    }

    public static void println(String string){
        System.out.println(string);
    }
}
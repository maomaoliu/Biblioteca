package tw.uitools;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestPrintTools {

    private static PipedOutputStream redirectedOutput_out;
    private static PipedInputStream redirectedOutput_in;
    public static PrintStream standardOutputStream;

    @BeforeClass
    public static void before() throws Exception {
        setUp();
    }

    private static void setUp() throws IOException {
        standardOutputStream = System.out;
        redirectedOutput_in = new PipedInputStream();
        redirectedOutput_out = new PipedOutputStream(redirectedOutput_in);
        System.setOut(new PrintStream(redirectedOutput_out));
    }

    @AfterClass
    public static void after() throws Exception {
        tearDown();
    }

    private static void tearDown() throws IOException {
        redirectedOutput_out.close();
        System.out.close();
        System.setOut(standardOutputStream);

    }

    @Test
    public void testPrintlnWithStars() throws IOException {
        String startsLine = "******************************************";
        PrintTools.printlnWithStars();
        assertEquals(startsLine, getFirst100CharsFromSystemOut());
    }

    @Test
    public void testPrintlnWithStar() throws IOException {
        String string = "X&Y";
        String expectStringWithStar = "*  X&Y                                   *";
        PrintTools.printlnWithStar(string);
        assertEquals(expectStringWithStar, getFirst100CharsFromSystemOut());
    }

    @Test
    public void testPrintln() throws IOException {
        String string = "TRUE";
        PrintTools.println(string);
        assertEquals(string, getFirst100CharsFromSystemOut());
    }

    public static String getFirst100CharsFromSystemOut() throws IOException {
        byte[] b = new byte[100];
        int len = 0;
        len = redirectedOutput_in.read(b);
        return new String(b, 0, len).trim();
    }
}

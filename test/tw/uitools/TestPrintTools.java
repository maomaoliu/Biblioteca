package tw.uitools;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        assertEquals(startsLine, getLineFromSystemOut());
    }

    @Test
    public void testPrintlnWithStar() throws IOException {
        String string = "X&Y";
        String expectStringWithStar = "*  X&Y                                   *";
        PrintTools.printlnWithStar(string);
        assertEquals(expectStringWithStar, getLineFromSystemOut());
    }

    @Test
    public void testPrintln() throws IOException {
        String string = "TRUE";
        PrintTools.println(string);
        assertEquals(string, getLineFromSystemOut());
    }

    public static String getLineFromSystemOut() throws IOException {
        /*byte[] b = new byte[100];
        int len = 0;
        len = redirectedOutput_in.read(b);
        return new String(b, 0, len).trim();*/
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        int byteData = redirectedOutput_in.read();
        while (byteData != -1 && byteData != (System.getProperty("line.separator")).getBytes()[0]) {
            bytes.add((byte) byteData);
            byteData = redirectedOutput_in.read();
        }
        byte[] byteD = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            byteD[i] = bytes.get(i);
        }
        return new String(byteD, 0, bytes.size()).trim();
    }
}

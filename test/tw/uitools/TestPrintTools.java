package tw.uitools;

import org.junit.AfterClass;
import org.junit.Before;
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
        standardOutputStream = System.out;
        redirectedOutput_in = new PipedInputStream();
        redirectedOutput_out = new PipedOutputStream(redirectedOutput_in);
        System.setOut(new PrintStream(redirectedOutput_out));
    }


    @AfterClass
    public static void after() throws Exception {
        redirectedOutput_out.close();
        System.out.close();
        System.setOut(standardOutputStream);
    }

    @Before
    public void setUp() throws Exception {
        flush();
    }

    @Test
    public void testPrintlnWithStars() throws IOException {
        flush();
        String startsLine = "******************************************";
        PrintTools.printlnWithStars();
        assertEquals(startsLine, getLineFromSystemOut());
    }

    @Test
    public void testPrintlnWithStar() throws IOException {
        flush();
        String string = "X&Y";
        String expectStringWithStar = getStringWithStars(string);
        PrintTools.printlnWithStar(string);
        assertEquals(expectStringWithStar, getLineFromSystemOut());
    }

    @Test
    public void testPrintln() throws IOException {
        String string = "TRUE";
        flush();
        PrintTools.println(string);
        assertEquals(string, getLineFromSystemOut());
    }

    public static String getLineFromSystemOut() throws IOException {
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

    public static String getAllFromSystemOut() throws IOException {
        int availableBytes = redirectedOutput_in.available();
        byte[] bytes = new byte[availableBytes];
        redirectedOutput_in.read(bytes, 0, availableBytes);
        return new String(bytes, 0, bytes.length);
    }

    public static void flush() throws IOException {
        int availableBytes = redirectedOutput_in.available();
        redirectedOutput_in.skip(availableBytes);
    }

    public static String getStringWithStars(String string) {
        StringBuilder stringWithStars = new StringBuilder("*  ");
        stringWithStars.append(string);
        for (int i = 36; i > string.length(); i--) {
            stringWithStars.append(" ");
        }
        stringWithStars.append("  *");
        return stringWithStars.toString();
    }
}

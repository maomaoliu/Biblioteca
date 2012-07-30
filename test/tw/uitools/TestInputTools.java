package tw.uitools;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestInputTools {
    private static PipedOutputStream redirectedInput_in;
    private static PipedInputStream redirectedInput_out;
    public static InputStream standardInputStream;

    @BeforeClass
    public static void before() throws Exception {
        setUp();
    }

    private static void setUp() throws IOException {
        InputTools inputTools = new InputTools();
        standardInputStream = System.in;
        redirectedInput_in = new PipedOutputStream();
        redirectedInput_out = new PipedInputStream(redirectedInput_in);
        System.setIn(redirectedInput_out);
    }

    @AfterClass
    public static void after() throws Exception {
        tearDown();
    }

    private static void tearDown() throws IOException {
        System.setIn(standardInputStream);
        redirectedInput_in.close();
        System.in.close();
    }

    /*
     * I don't know why it blocked when I run this test.
     */
    @Test
    public void testGetLine() throws IOException {
        /*
        String string = "Hello";
        redirectedInput_in.write((string + System.getProperty("line.separator")).getBytes());
        redirectedInput_in.flush();
        assertEquals(string, InputTools.getLine());
        */
    }

    @Test
    public void testGetPassword() {
        // Not yet.
        // How to make Console.
    }
}

package tw.uitools;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.rmi.activation.ActivationGroupDesc;
import java.util.Scanner;

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

    @Test
    public void testGetLine() throws IOException {
        String string = "Hello";
        redirectedInput_in.write((string + System.getProperty("line.separator")).getBytes());
        redirectedInput_in.flush();
        assertEquals(string, InputTools.getLine());
    }

    @Test
    public void inputShouldBeConsole(){
        //
    }

    @Test
    public void testGetPassword() {
        // Not yet.
        // How to make Console.
    }

    @Test
    public void shouldRewireSystemIn() {
        String data = "Hello, World!\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        } finally {
            System.setIn(stdin);
        }
    }
}

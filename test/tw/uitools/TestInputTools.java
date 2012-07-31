package tw.uitools;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Console.class, System.class, InputTools.class})

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
    public void inputShouldBeConsole() {
        InputTools.setInput(PowerMock.createMock(Console.class));
        assertEquals(Console.class, InputTools.getInput().getClass());
    }

    @Test
    public void inputShouldBeScanner() {
        InputTools.setInput(new Scanner(System.in));
        assertEquals(Scanner.class, InputTools.getInput().getClass());
    }

    @Test
    public void testGetLineWithScanner() throws IOException {
        InputTools.setInput(new Scanner(System.in));
        String string = "Hello";
        redirectedInput_in.write((string + System.getProperty("line.separator")).getBytes());
        redirectedInput_in.flush();
        assertEquals(string, InputTools.getLine());
    }

    @Test
    public void testGetLineWithConsole() throws Exception {
        String string = "Hello";
        InputTools.getInput();
        PowerMock.mockStatic(System.class);
        Console consoleMock = PowerMock.createMock(Console.class);
        EasyMock.expect(consoleMock.readLine()).andReturn(string);
        PowerMock.replayAll();
        InputTools.setInput(consoleMock);
        assertEquals(string, InputTools.getLine());
        PowerMock.verifyAll();
    }

    @Test
    public void testGetPassword() throws IOException {
        String password = "password";
        InputTools.getInput();
        PowerMock.mockStatic(System.class);
        Console consoleMock = PowerMock.createMock(Console.class);
        EasyMock.expect(consoleMock.readPassword()).andReturn(password.toCharArray());
        PowerMock.replayAll();
        InputTools.setInput(consoleMock);
        assertEquals(password, InputTools.getPassword());
        PowerMock.verifyAll();
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

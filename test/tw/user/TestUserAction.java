package tw.user;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tw.uitools.TestInputTools;
import tw.uitools.TestPrintTools;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestUserAction {
    UserAction userAction = new UserAction();

    @BeforeClass
    public static void before() throws Exception {
        TestInputTools.before();
        TestPrintTools.before();
    }

    @AfterClass
    public static void after() throws Exception {
        TestInputTools.after();
        TestPrintTools.after();
    }

    @Before
    public void setUp() throws Exception {
        TestInputTools.flush();
        TestPrintTools.flush();
    }

    @Test
    public void shouldLoginWithRightInput() {
        assertEquals("User 111-1111, welcome here!", userAction.login("111-1111", "pw1"));
        assertEquals("111-1111", userAction.getUsername());
    }

    @Test
    public void shouldNotLoginWithWrongInput() {
        assertEquals("Username/password is not correct.", userAction.login("11", "er"));
        assertEquals(null, userAction.getUsername());
    }

    @Test
    public void testActionShouldLogin() throws IOException {
        TestInputTools.inputLine("111-1111");
        TestInputTools.inputLine("pw1");
        userAction.action();
        assertEquals("Input username, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input password, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("User 111-1111, welcome here!", TestPrintTools.getLineFromSystemOut());
    }

    @Test
    public void testActionShouldNotLogin() throws IOException {
        TestInputTools.inputLine("111-11211");
        TestInputTools.inputLine("pw1");
        userAction.action();
        assertEquals("Input username, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input password, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Username/password is not correct.", TestPrintTools.getLineFromSystemOut());
    }
}

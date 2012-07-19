package tw.test;

import org.junit.Test;
import tw.main.LoginAction;

import static org.junit.Assert.assertEquals;

public class TestLoginAction {
    LoginAction loginAction = new LoginAction();

    @Test
    public void testShouldLoginWithRightInput() {
        assertEquals("User 111-1111, welcome here!", loginAction.login("111-1111", "pw1"));
        assertEquals("111-1111", loginAction.getUsername());
    }

    @Test
    public void testShouldNotLoginWithWrongInput() {
        assertEquals("Username/password is not correct.", loginAction.login("11", "er"));
        assertEquals(null, loginAction.getUsername());
    }
}

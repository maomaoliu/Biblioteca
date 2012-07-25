package tw.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUserAction {
    UserAction userAction = new UserAction();

    @Test
    public void testShouldLoginWithRightInput() {
        assertEquals("User 111-1111, welcome here!", userAction.login("111-1111", "pw1"));
        assertEquals("111-1111", userAction.getUsername());
    }

    @Test
    public void testShouldNotLoginWithWrongInput() {
        assertEquals("Username/password is not correct.", userAction.login("11", "er"));
        assertEquals(null, userAction.getUsername());
    }
}

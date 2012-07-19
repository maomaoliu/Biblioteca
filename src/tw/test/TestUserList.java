package tw.test;

import org.junit.Test;
import tw.main.UserList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserList {

    private UserList userList = UserList.getInstance();

    @Test
    public void shouldLoginWithRightInput(){
        assertTrue(userList.canLogin("111-1111", "pw1"));
        assertTrue(userList.canLogin("111-1114", "pw4"));
    }

    @Test
    public void shouldLoginWithWrongInput(){
        assertFalse(userList.canLogin("111-1111", "pw11"));
    }
}

package tw.user;

import org.junit.Test;
import tw.user.UserList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserList {

    private UserList userList = UserList.getInstance();

    @Test
    public void shouldHasUser(){
        assertTrue(userList.hasUser(new User("111-1111", "pw1")));
        assertTrue(userList.hasUser(new User("111-1114", "pw4")));
    }

     @Test
    public void shouldNotHasUser(){
        assertFalse(userList.hasUser(new User("111-1111", "pw11")));
    }
}

package tw.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestUser {
    @Test
    public void testShouldEquals() {
        User user1 = new User("u1", "p1");
        User user2 = new User("u1", "p1");
        assertEquals(user1, user2);
    }

    @Test
    public void testShouldNotEquals() {
        User user1 = new User("u1", "p1");
        User user2 = new User("u2", "p1");
        User user3 = new User("u1", "p2");
        assertFalse(user1.equals(user2));
        assertFalse(user1.equals(user3));
        assertFalse(user2.equals(user3));
    }
}

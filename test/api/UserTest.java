package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Sam","James","James.S","3202","user");
    }

    @Test
    public void getName() {
        assertEquals(user.getName(),"Sam");
    }

    @Test
    public void getSurname() {
        assertEquals(user.getSurname(),"James");
    }

    @Test
    public void getUsername() {
        assertEquals(user.getUsername(),"James.S");
    }

    @Test
    public void getPassword() {
        assertEquals(user.getPassword(),"3202");
    }

    @Test
    public void getType() {
        assertEquals(user.getType(),"user");
    }

    @Test
    public void testEquals() {
        User user1 = new User("Sam","James","James.S","3202","user");
        User user2 = new User("Sam2","James2","James.s2","32022","user2");
        assertTrue(user.equals(user1));
        assertFalse(user.equals(user2));
    }
}
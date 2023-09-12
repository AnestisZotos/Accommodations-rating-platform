package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentUserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Steph","ball","sball","4545","provider");
        CurrentUser.setCurrentUser(user);
    }

    @Test
    public void getCurrentUser() {
        assertEquals(CurrentUser.getCurrentUser(),user);
    }

    @Test
    public void setCurrentUser() {
        User us = new User("Steph2","ball2","sball2","45452","provider2");
        CurrentUser.setCurrentUser(us);
        assertEquals(CurrentUser.getCurrentUser().getUsername(),us.getUsername());
    }
}
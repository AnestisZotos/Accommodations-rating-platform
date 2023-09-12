package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class AllUsersTest {

    AllUsers allUsers;

    @Before
    public void setUp() throws Exception {
        User user = new User("nick","Pap","nick.p","12345","user");
        User user2 = new User("paul","geo","geop","123456","provider");

        allUsers = new AllUsers();
        allUsers.addUser(user);
        allUsers.addUser(user2);
    }

    @Test
    public void addUser() {
        User us = new User("paul2","geo2","geop2","1234562","provider");
        allUsers.addUser(us);
        assertEquals(allUsers.searchUserByUsername(us.getUsername()).getUsername(),us.getUsername());
    }

    @Test
    public void testAddUser() {
        allUsers.addUser("jim","liar","jiml","123","provider");
        assertEquals(allUsers.searchUserByUsername("jiml").getUsername(),"jiml");
    }

    @Test
    public void removeUser() {
        allUsers.removeUser(allUsers.searchUserByUsername("nick.p"));
        assertNull(allUsers.searchUserByUsername("nick.p"));
    }

    @Test
    public void searchUserByUsername() {
        assertEquals(allUsers.searchUserByUsername("geop").getPassword(),"123456");
        assertNull(allUsers.searchUserByUsername("username"));
    }

    @Test
    public void getAllUsers() {
        ArrayList<User> list = allUsers.getAllUsers();
        assertEquals(list.size(),2);
    }
}
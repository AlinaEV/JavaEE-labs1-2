

import dao.UserDAO;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.MongoLanguageService;

/**
 *
 * @author Alona
 */
public class MongoDAOTest {
    
    private UserDAO userDAO;
    
    public MongoDAOTest() {
        //userDAO = MongoLanguageService.getInstance().getUserDAO();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertUser method, of class MongoDBUserDAO.
     */
    @org.junit.Test
    public void testInsertUser() throws SQLException {
        System.out.println("insertUser");
        User user = new User();
        user.setEmail("email@e.com");
        user.setPassword("123");
        user.setLogin("name");
        
        userDAO.add(user);
        ArrayList<User> users = new ArrayList<>(userDAO.getAll());
        assertEquals("Email of inserted fail",user.getEmail(), users.get(users.size()-1).getEmail());
        assertEquals("Password of inserted fail",user.getPassword(), users.get(users.size()-1).getPassword());
        assertEquals("Username of inserted fail",user.getLogin(), users.get(users.size()-1).getLogin());
    }

    /**
     * Test of deleteUser method, of class MongoDBUserDAO.
     */
    @org.junit.Test
    public void testDeleteUser() throws SQLException {
        System.out.println("deleteUser");
        ArrayList<User> users = new ArrayList<>(userDAO.getAll());
        for(User us:users)
            userDAO.remove(us);

        ArrayList<User> usersNew = new ArrayList<>(userDAO.getAll());
        assertEquals(0, usersNew.size());
    }

    /**
     * Test of updateUser method, of class MongoDBUserDAO.
     */
    @org.junit.Test
    public void testUpdateUser() throws SQLException {
        System.out.println("updateUser");
        User userUpd = new User();
        userUpd.setEmail("emailUpd@e.com");
        userUpd.setPassword("123Upd");
        userUpd.setLogin("nameUpd");
        userDAO.add(userUpd);
        userUpd.setEmail("updated@u.com");
        userUpd.setPassword("UpdatedPass");
        userUpd.setLogin("usernameUpdated");
        userDAO.update(userUpd);
        ArrayList<User> users = new ArrayList<>(userDAO.getAll());
    }

    /**
     * Test of getAllUsers method, of class MongoDBUserDAO.
     */
    @org.junit.Test
    public void testGetAllUsers() throws SQLException {
        System.out.println("getAllUsers");
        User user1 = new User();
        user1.setEmail("email1@e.com");
        user1.setPassword("1231");
        user1.setLogin("name1");
        
        User user2 = new User();
        user2.setEmail("email2@e.com");
        user2.setPassword("1232");
        user2.setLogin("name2");
        
        User user3 = new User();
        user3.setEmail("email3@e.com");
        user3.setPassword("1233");
        user1.setLogin("name3");
        
        userDAO.add(user1);
        userDAO.add(user2);
        userDAO.add(user3);
        ArrayList<User> users = new ArrayList<>(userDAO.getAll());
        Collection result = userDAO.getAll();
        assertEquals(3, users.size());
    }
    
}

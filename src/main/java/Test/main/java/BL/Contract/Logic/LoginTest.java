package main.java.BL.Contract.Logic;

import main.java.BL.Contract.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Unit testing for validation

public class LoginTest {

    static Login login;
    private String userName = "admin";
    private String password = "1234";
    private String userNoExist = "alon";


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        login = new Login();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


    @Test
    public void login_existUserName_success() throws Exception {

        User result = login.LogInSystem(userName,password);
        assertEquals(userName, result.getUserName());
    }

    @Test
    public void login_noExistUserName_failedLogin() throws Exception {

        User result = login.LogInSystem(userNoExist,password);
        assertEquals(null, result.getUserName());
    }
}

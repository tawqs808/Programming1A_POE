package programming1a_poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    // Test that a correctly formatted username returns true 
    @Test
    public void checkUserName() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "password",
                "+27818796451"
        );

        assertTrue(user.checkUserName());
    }

    // Test that a incorrectly formatted username returns false 
    @Test
    public void testUsernameIncorrectlyFormatted() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1!!!!!!!",
                "password",
                "+27818796451"
        );

        assertFalse(user.checkUserName());
    }

    // Test that the password meets all the complexity rules and returns true 
    @Test
    public void testPasswordMeetsComplexity() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "Taw@eer1",
                "+27818796451"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test that a password not meeting the complexity rules returns false 
    @Test
    public void testPasswordDoesNotMeetComplexity() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "password",
                "+27818796451"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test that a correctly formatted South African cellphone number returns true
    @Test
    public void testCellPhoneCorrectlyFormatted() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "Taw@eer1",
                "+27818796451"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    // Test that an incorrectly formatted South African cellphone number returns false 
    @Test
    public void testCellPhoneIncorrectlyFormatted() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "Taw@eer1",
                "0818796"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    // Tests that the correct username and password result in a successful login 
    @Test
    public void testLoginSuccessful() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "Taw@eer1",
                "+27818796451"
        );

        user.setLoginDetails(
                 "taw_1",
                "Taw@eer1"
        );

        assertTrue(user.loginUser());
    }

    // Tests that incorrect login details result in a failed login 
    @Test
    public void testLoginFailed() {

        Login user = new Login(
                "Tawqeer",
                "Ismail",
                "taw_1",
                "Taw@eer1",
                "+27818796451"
        );

        user.setLoginDetails(
                "wrong",
                "wrongPassword"
        );

        assertFalse(user.loginUser());
    }
}
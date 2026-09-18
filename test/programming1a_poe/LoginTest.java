package programming1a_poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

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
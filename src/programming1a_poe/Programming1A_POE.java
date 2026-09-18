package programming1a_poe;

import java.util.Scanner;

public class Programming1A_POE {

    public static void main(String[] args) {

        // Scanner is used to collect input from the user 
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO THE CHAT APP");
        System.out.println("-----------------------");

        // Collect the users personal information
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

         // Collect the users personal information
        System.out.print("Enter your last name:");
        String lastName = input.nextLine();

        System.out.println();
        System.out.println("CREATE AN ACCOUNT");
        System.out.println("-----------------");

        // Collects users registration details 
        System.out.print("Enter a username: ");
        String username = input.nextLine();

        // Collects users registration details
        System.out.print("Enter a password: ");
        String password = input.nextLine();

        // Collects users registration details
        System.out.print("Enter your South African cell phone number (+27): ");
        String cellPhoneNumber = input.nextLine();

        // Create a login object using the information entered by the user 
        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );

        System.out.println();

        // Checks if the user name is correctly formatted 
        if (user.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println(
                    "Username is not correctly formatted; please ensure that "
                    + "your username contains an underscore and is no more "
                    + "than five characters in length."
            );
        }

        // Checks if the password meets the required complexity rules 
        if (user.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println(
                    "Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, "
                    + "a capital letter, a number, and a special character."
            );
        }

        // Checks if the South African cellphone number is correctly formatted 
        if (user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println(
                    "Cell phone number incorrectly formatted or does not "
                    + "contain an international code; please correct "
                    + "the number and try again."
            );
        }

        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            // Only allow user to login if the registration is successful
            System.out.println();
            System.out.println("REGISTRATION SUCCESSFUL");

            System.out.println();
            System.out.println("LOGIN");
            System.out.println("-----");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            // Store the login details entered by the user 
            user.setLoginDetails(loginUsername, loginPassword);

            // Display whether the login was successful or unsuccessful
            System.out.println();
            System.out.println(user.returnLoginStatus());

        } else {

            System.out.println();
            System.out.println(
                    "Registration unsuccessful. Please correct the information above."
            );
        }

        input.close();
    }
}
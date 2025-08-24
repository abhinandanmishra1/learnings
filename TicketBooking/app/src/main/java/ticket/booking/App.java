package ticket.booking;

import ticket.booking.entities.User;
import ticket.booking.services.LoginService;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            LoginService loginService = new LoginService();
            User user = loginService.login("abcdefgh", "12345");

            if (user != null)
                System.out.printf("User %s logged in%n", user.getName());
            else
                System.out.println("Wrong username or password");
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        System.out.println("App started");
    }
}

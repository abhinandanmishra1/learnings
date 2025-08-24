package ticket.booking.services;

import ticket.booking.entities.User;

public class LoginService {
    private User user;

    public String login(User user) {
        return "auth_token";
    }
}

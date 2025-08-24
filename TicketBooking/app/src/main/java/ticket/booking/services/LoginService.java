package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Null;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private User user;
    private List<User> users = new ArrayList<User>();
    private static final String USERS_PATH = "app/src/main/java/ticket/booking/db/users.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public LoginService() throws IOException {
        File file = new File(USERS_PATH);
        users = objectMapper.readValue(file, new TypeReference<List<User>>(){});
        this.users = users;
    }

    public User login(String user_id, String password) {
        User foundUser = users.stream()
                .filter(u -> u.getUser_id().equals(user_id) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        return foundUser;
    }
}

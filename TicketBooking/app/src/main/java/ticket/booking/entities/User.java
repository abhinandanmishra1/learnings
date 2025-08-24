package ticket.booking.entities;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
public class User {

    public String user_id;
    private String name;
    private String password;
    private String hashed_password;
    private List<String> booked_tickets = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }
}

package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingService {
    private User user;
    public static final String TICKETS_PATH = "app/src/main/java/ticket/booking/db/tickets.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService(User user) {
        this.user = user;
    }

    public Ticket bookTicket(Train train, String source, String destination) throws IOException {
        Ticket ticket = new Ticket(user.getUser_id(), source, destination, train.getTrain_id());
        File file = new File(TICKETS_PATH);
        List<Ticket> allTickets = objectMapper.readValue(file, new TypeReference<List<Ticket>>(){});
        allTickets.add(ticket);
        System.out.println(allTickets);
        objectMapper.writeValue(file, allTickets);
        return ticket;
    }
}

package ticket.booking.entities;

import java.util.Date;
import java.util.Random;

public class Ticket {
    private String ticket_id;
    private String user_id;
    private String source;
    private String destination;
    private Date date_of_travel;
    private String train_id;

    public Ticket() {}

    public Ticket(String user_id, String source, String destination, String train_id) {
        this.user_id = user_id;
        this.source = source;
        this.destination = destination;
        this.train_id = train_id;
        this.date_of_travel = new Date();
        this.ticket_id = new Random().toString();
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getTrain_id() {
        return train_id;
    }

    public Date getDate_of_travel() {
        return date_of_travel;
    }
}

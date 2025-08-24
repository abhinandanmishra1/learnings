package ticket.booking.entities;

import lombok.Data;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@Data
public class Train {
    private String train_id;
    private String train_no;
    List<List<Integer>> seats;
    private Map<String, Time> station_times;
    private List<String> stations;
    private String train_info;

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public List<String> getStations() {
        return stations;
    }

    public String getTrain_id() {
        return train_id;
    }
}

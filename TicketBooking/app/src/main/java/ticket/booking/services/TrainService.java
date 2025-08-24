package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
    public static final String TRAINS_PATH = "app/src/main/java/ticket/booking/db/trains.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Train> trains = new ArrayList<>();

    public TrainService() throws IOException {
        loadTrains();
    }

    void loadTrains() throws IOException {
        File file = new File(TRAINS_PATH);
        trains = objectMapper.readValue(file, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrains(String source, String destination) {
        return
                trains.stream().filter(train -> {
                    List<String> stations = train.getStations();

                    return
                            stations.contains(source)
                                    && stations.contains(destination)
                                    && stations.indexOf(source) < stations.indexOf(destination);
                }).collect(Collectors.toList())

        ;
    }

    public Train getTrainById(String trainId) {
        return
                trains
                        .stream()
                        .filter(
                                train -> train
                                        .getTrain_id()
                                        .equals(trainId))
                        .findFirst()
                        .orElse(null);
    }
}

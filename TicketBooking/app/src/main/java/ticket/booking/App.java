package ticket.booking;

import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.LoginService;
import ticket.booking.services.TrainService;
import ticket.booking.services.UserBookingService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            LoginService loginService = new LoginService();
            TrainService trainService = new TrainService();

            User user = loginService.login("abcdefgh", "12345");

            if (user != null)
                System.out.printf("User %s logged in%n", user.getName());
            else {
                System.out.println("Wrong username or password");
                return;
            }

            System.out.print("Enter source: ");
            String source = scanner.nextLine();

            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();
            List<Train> trains =  trainService.searchTrains(source, destination);

            if (trains == null) {
                System.out.printf("There are no trains available from %s to %s", source, destination);
                return;
            }

            trains.stream().forEach(train -> {
                System.out.println(train);
            });

            System.out.printf("Select train from 1 to %d", trains.size());
            Integer selectedTrainIndex = scanner.nextInt();

            Train selectedTrain = trains.get(selectedTrainIndex-1);

            System.out.println("Select Seats");
            List<List<Integer>> seats = selectedTrain.getSeats();

            for(int i=0; i<seats.size(); i++) {
                for(int j=0; j<seats.size(); j++) {
                    System.out.printf("Seat at [%d, %d] is %s", i+1, j+1, seats.get(i).get(j) == 0? "available\n": "unavailable\n");
                }
            }

            System.out.println("Select seat position");
            Integer row = scanner.nextInt(), column = scanner.nextInt();

            while(seats.get(row-1).get(column-1) == 1) {
                System.out.println("Seat is not available, select again ");
                row = scanner.nextInt();
                column = scanner.nextInt();
            }

            System.out.println("Confirm booking the ticket? yes/no");
            String confirmation = scanner.next();
            if(confirmation.equals("no")) {
                System.out.println("Ticket booking is cancelled.");
                return;
            }

            UserBookingService bookingService = new UserBookingService(user);

            Ticket ticket = bookingService.bookTicket(selectedTrain, source, destination);

            System.out.printf("Booked ticket with ticketId: %s", ticket.getTicket_id());
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        System.out.println("App started");
    }
}

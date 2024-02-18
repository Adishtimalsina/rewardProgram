
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Main method reads passenger information from a file, then calculates and displays their reward miles and which reward tier they are on.
 */
public class Main {

    /**
     * The Main method reads passenger information from a file, it then calculates and displays their reward miles and tier.
     */
    public static void main(String[] args) {


        //Arraylist of object of the class Passenger
        List<Passenger> passengers = new ArrayList<>();


        //Getting inputs from the input file and also handeling exceptions
        try (BufferedReader reader = new BufferedReader(new FileReader("flightdata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if(parts.length < 1) continue;

                if(parts.length > 1) {
                    int ID = Integer.parseInt(parts[0]); //parse passenger id from input data (column 0)
                    boolean cancelled = Objects.equals(parts[1], "Y");
                    boolean passengerExist = passengers.stream().anyMatch(p -> p.getId() == ID);
                    if(passengerExist) {
                        passengers = new ArrayList<>(passengers.stream().peek(p -> {
                            if(p.getId() == ID) {
                                p.addFlight(cancelled);
                                if(cancelled && parts[2].equals("Y")) {
                                    p.addComplaint();
                                }
                            }
                        }).toList());
                    } else {
                        Passenger passenger = new Passenger();
                        passenger.setId(ID);
                        passenger.addFlight(cancelled);
                        passengers.add(passenger);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        new RewardUI(passengers);
        System.out.println("Press 'q' to Quit Program.");

        //below two lines for debugging purpose to see the all passengers ID
        //System.out.println("Passengers");
        //System.out.println(passengers.stream().map(Passenger::getId).toList());

        boolean quit = false;
        System.out.println("\nWelcome to NorthEast Airlines Reward Program.");
        System.out.println("================================================\n");

        do{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please Provide Passenger ID: ");
            String input = scanner.nextLine();
            int ID = 0;

            // if user inputs quit or q then the program exits
            if(input.equals("q")) {
                quit = true;
                System.out.println("Quiting the program.");
                continue;
            }
            try {
                ID = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid ID, ID must be a number");
                continue;
            }

            // Create Passenger object with user input
            int finalId = ID;
            Passenger passenger = passengers.stream().filter(p -> p.getId() == finalId).findFirst().orElse(null);
            if(passenger == null) {
                System.out.println("Passenger " + ID + " does not exist on the list");
                System.out.println("Please check passenger ID again.\n");
                continue;
            }

            //for UI
            int passangerID = passenger.getId();
            String rewardTire = passenger.getTier();
            int cancledFlight = passenger.getCancelledFlights();
            boolean multiplier = passenger.hasMultiplier();


            // Display passenger information about their reward status.
            int rewardMiles = passenger.getMiles();
            System.out.println("Passenger ID: " + passenger.getId());
            System.out.println("Passenger "+passenger.getId()+" earned " + rewardMiles + " miles this year.");
            System.out.println("Passenger is on: " + passenger.getTier() + ".");
            System.out.println("Total number of cancelled flight is " + passenger.getCancelledFlights() + ".");
            System.out.println("Passenger has multiplier: " + (passenger.hasMultiplier() ? "Yes" : "No"));
            System.out.println();
        } while (!quit);


    }

}

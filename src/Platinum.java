/**
 The Platinum class represents a reward tier for a cancellation program.
 This tier has a name, miles, flight cancellations, and flights. For every flight cancellation, they are rewarded 1000 miles.
 To reach to this tier you must have >= 50 flight cancellations
 */
public class Platinum implements Tier {
    private String name = "Platinum";
    private int miles = 1000;
    private int flightCancellations = 50;
    private int flights = 50;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMiles() {
        return miles;
    }

    @Override
    public int getCancelledFlights() {
        return flightCancellations;
    }

    @Override
    public int getFlights() {
        return flights;
    }

    @Override
    public void addFlight(boolean isCancelled) {
        if(isCancelled) {
            flights++;
        }
    }
}


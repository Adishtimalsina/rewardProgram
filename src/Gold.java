/**
 * The `Gold` class represents a type of reward tier that
 * implements the `Tier` interface. Gold members earn 1000 miles per flight cancellation.
 * must be 25 > flight cancellations.
 */
public class Gold implements Tier {
    //Initilizing name of the tier, that the passenger is on
    private String name = "Gold";

    //Initinizing the initial miles, if the passenger flight was cancelled
    private int miles = 1000;

    //initilize minimum cancellation flight to be on reward program
    private int flightCancellations = 25;

    //initilizing minimum flight
    private int flights = 25;

    //overriding methods from Tier
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMiles() {
        return miles ;
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
            flights++; //updating the flights
        }
    }

}

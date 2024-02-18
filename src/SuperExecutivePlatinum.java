/**
 * This reward program extends executive platinum class, in this class passenger are able to earn mileage multiplier.
 * ie passenger can earn 2000 miles per cancellation flight, if passenger did not complain about cancelled flights.
 */
public class SuperExecutivePlatinum extends ExecutivePlatinum {
    private String name = "Super Executive Platinum"; //initilizing tier name
    private int multiplier = 2; //if passenger has multiplier, passenger earn double the miles

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMiles() {
        return super.getMiles() * multiplier;
    }

    @Override
    public int getCancelledFlights() {
        return super.getCancelledFlights();
    }
}

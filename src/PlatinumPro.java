/**
 * This reward program extends platinum class. if passenger has 50 or more cancelled flights
 * and passenger did not complain then passenger earn milage multiplier. ie passenger can earn 2000 miles
 * per each cancelled flights
 */

public class PlatinumPro extends Platinum {
    private final String name = "Platinum Pro";
    private final int multiplier = 2;

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

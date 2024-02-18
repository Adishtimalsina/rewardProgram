/**
 * This is base interface class
 * This interface represents a tier in an airline reward program.
 */
public interface Tier {
    String getName();
    int getMiles();
    int getCancelledFlights();
    int getFlights();
    void addFlight(boolean isCancelled);
}

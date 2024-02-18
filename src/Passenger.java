/**
 * The Passenger class represents a passenger in the reward program. A passenger has an ID, a tier,
 * a number of miles earned, a number of cancelled flights. A passenger can
 * also have a multiplier and can earn rewards based on the number of cancelled flights and their tier.
 * If the passenger never complained about a cancelled flight, they may be upgraded based on their reward tier
 */
public class Passenger {
    private int ID;
    private Tier tier;
    private int miles;
    private int cancelledFlights;
    private int complaints = 0;
    private boolean hasMultiplier = false;
    private int numFlights;

    public Passenger() {
        this.tier = null;
        this.miles = 0;
        this.cancelledFlights = 0;
        this.hasMultiplier = false;
        this.numFlights = 0;
    }


    // Returns the passenger's tier as a string. If the passenger has no tier, returns "No Tier".
    //return the passenger's tier as a string

    public String getTier() {
        if (tier == null) {
            return "Passenger does not have any tier";
        } else {
            return tier.getName();
        }
    }


    // Returns the number of miles earned by the passenger.
    //return the number of miles earned by the passenger

    public int getMiles() {
        return miles;
    }


    public int getCancelledFlights() {
        return cancelledFlights;
    }


    // Returns whether the passenger has a multiplier or not.
    // return  true if the passenger has a multiplier, false otherwise

    public boolean hasMultiplier() {
        return hasMultiplier;
    }


    // Adds a flight for the passenger. If the flight is cancelled, increments the number of cancelled flights
    //for the passenger and checks if the passenger is eligible for an upgrade.
    // return isCancelled true if the flight was cancelled, false otherwise

    public void addFlight(boolean isCancelled) {
        numFlights++;

        if(isCancelled) {
            cancelledFlights++;
            checkForUpgrade();
            if(tier != null) {
                tier.addFlight(true);
            }
        }
    }

    public void addComplaint() {
        complaints++;
    } //adding passenger complaints

    public int getId() {
        return ID;
    }

    //setting passenger ID
    public void setId(int ID) {
        this.ID = ID;
    }


    // Checks if the passenger is eligible for an upgrade and upgrades their tier if necessary.

    public void checkForUpgrade() {

        if (tier == null) {
            if (cancelledFlights >= 25) {
                tier = new Gold();
            }
        } else {
            hasMultiplier = complaints == 0;
            if(cancelledFlights >= 100) {
                if(hasMultiplier) {
                    tier = new SuperExecutivePlatinum(); //if has a multiplier upgrade to the new tier, superexecutiveplatinum
                } else {
                    tier = new ExecutivePlatinum(); //else keep the same reward tier
                }
            } else if(cancelledFlights >= 50) {
                if(hasMultiplier) {
                    tier = new PlatinumPro(); //if has a multiplier then upgrade to the platinumpro
                } else {
                    tier = new Platinum(); // else keep the same reward tier
                }
            } else if(cancelledFlights >= 25) {
                tier = new Gold();
            }
            miles = tier.getMiles() * cancelledFlights; //getting total miles passenger earned
        }
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + ID +
                ", tier=" + tier +
                ", miles=" + miles +
                ", cancelledFlights=" + cancelledFlights +
                ", complaints=" + complaints +
                ", hasMultiplier=" + hasMultiplier +
                ", numFlights=" + numFlights +
                '}';
    }
}

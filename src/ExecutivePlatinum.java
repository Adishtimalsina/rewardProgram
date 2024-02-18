/**
 *Executive platinum implements Tier class, Passenger can earn this reward if they have 100 cancelled flight or more within one year
 * passenger can earn 1000 miles for each cancelled flight.
 */
public class ExecutivePlatinum implements Tier{
    private String name = "Executive Platinum"; //tier name
    private int miles = 1000;
    private int cancelledFlights = 100;
    private int totalFlights = 100;


    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getMiles(){
        return miles;
    }
    @Override
    public int getCancelledFlights(){
        return cancelledFlights;
    }
    @Override
    public int getFlights(){
        return totalFlights;
    }
    @Override
    public void addFlight(boolean isCancelled){
        if(isCancelled){
            totalFlights++; //updating flights
        }

    }

}

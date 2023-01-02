import java.sql.SQLException;

public class Management {
    private boolean availability;

    // getters and setters
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Management() {
        // constructor
    }

    public void refillRepo(){
        Repository repodetails = new Repository();
        double stock = repodetails.getRemainingStock();
        if (stock < 500){
            // refill stock

        } else if (stock > 500) {
            // continue
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Runnable obj1 = (Runnable) new MainQueue();
        Thread t1 = new Thread(obj1);
        t1.start();

        Queue eachCustomer = new Queue();
        eachCustomer.addingCustomer();

        OctaneFuelDispenseManager oct = new OctaneFuelDispenseManager();
        oct.fuelType();
        oct.totalIncome();
        oct.totalNumberOfVehiclesServed();
        oct.remainningStock();
        oct.vehiclesThatReceivedTheLargestAmountOfFuel();
        DieselFuelDispenseManager diesel = new DieselFuelDispenseManager();
        diesel.fuelType();
        diesel.totalIncome();
        diesel.remainningStock();
        diesel.totalFuelDispensedPerVehicle();
        diesel.vehiclesThatReceivedTheLargestAmountOfFuel();
    }
}

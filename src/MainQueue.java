import java.sql.SQLException;
import java.util.ArrayList;

public class MainQueue extends Queue{
    private  int queueLength;
    // getters and setters
    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    public MainQueue() {
        // constructor
    }

    public void checkTicket(){
        // this method is used to check whether the customer has a ticket
    }

    public static void checkVehicle() throws SQLException, ClassNotFoundException {
        MainQueue length = new MainQueue();
        int count = 0;
        Queue eachCustomer = new Queue();
        eachCustomer.addingCustomer();
        String vehicleType = eachCustomer.getCustomerArrayList().get(0).getVehicleType();
        if (vehicleType.equals("car")){
            count += 1;
            length.setQueueLength(count);
        }

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        checkVehicle();
    }
}

import java.sql.*;

public class OctaneFuelDispenseManager implements FuelDispenseManager{
    @Override
    public void fuelType() {
        System.out.println("Here comes octane repositories");
    }

    @Override
    public void totalIncome() throws SQLException, ClassNotFoundException {
        Payment pay = new Payment();
        pay.PaymentforOctane();
    }

    @Override
    public void totalFuelDispensedPerVehicle() {

    }

    @Override
    public void totalNumberOfVehiclesServed() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.totalVehicles();
    }

    @Override
    public void vehiclesThatReceivedTheLargestAmountOfFuel() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.largeAmount();
    }

    @Override
    public void remainningStock() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.remainingStock();
    }

}


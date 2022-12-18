import java.sql.SQLException;

public class DieselFuelDispenseManager implements FuelDispenseManager{

    @Override
    public void fuelType() {
        System.out.println("Here comes diesel repositories");
    }

    @Override
    public void totalIncome() throws SQLException, ClassNotFoundException {
        Payment pay = new Payment();
        pay.paymentForDiesel();
    }

    @Override
    public void totalFuelDispensedPerVehicle() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.totalVehiclesDiesel();
    }

    @Override
    public void totalNumberOfVehiclesServed() {

    }

    @Override
    public void vehiclesThatReceivedTheLargestAmountOfFuel() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.largeAmountdiesel();
    }

    @Override
    public void remainningStock() throws SQLException, ClassNotFoundException {
        system sys = new system();
        sys.remainingStockDiesel();
    }
}

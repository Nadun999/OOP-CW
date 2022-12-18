import java.sql.SQLException;

public interface FuelDispenseManager {
    public void fuelType(
            // storing the fuel type of repositories
    );
    public void totalIncome(
            // calculating the total income

    ) throws SQLException, ClassNotFoundException;
    public void totalFuelDispensedPerVehicle(
            // this method calculated the total fuel count pumped for a vehicle
    ) throws SQLException, ClassNotFoundException;
    public void totalNumberOfVehiclesServed(
            // this method calculates number of vehicles that served in each dispenser
    ) throws SQLException, ClassNotFoundException;
    public void vehiclesThatReceivedTheLargestAmountOfFuel(
            // keeping track of the vehicles that received the largest amount of fuel
    ) throws SQLException, ClassNotFoundException;
    public void remainningStock(
            // keeping track of remaining fuel count
    ) throws SQLException, ClassNotFoundException;
}


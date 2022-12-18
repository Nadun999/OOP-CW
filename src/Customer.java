import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private int qrNumber;
    private int idNo;
    private String vehicleType;
    private String fuelType;

    // getters and setters
    public int getQrNumber() {
        return qrNumber;
    }

    public void setQrNumber(int qrNumber) {
        this.qrNumber = qrNumber;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Customer() {
        // constructor
    }

    public void newCustomer(){

    }

    public static void main(String[] args) {
        //newCustomer();
    }
}

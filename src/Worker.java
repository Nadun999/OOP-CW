import java.util.ArrayList;

public class Worker {
    private int workerId;
    private String workingStation;
    private ArrayList<Payment> paymentArrayList = new ArrayList<>();

    public Worker() {
        // constructor
    }

    // getters and setters
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getWorkingStation() {
        return workingStation;
    }

    public void setWorkingStation(String workingStation) {
        this.workingStation = workingStation;
    }

    public ArrayList<Payment> getPaymentArrayList() {
        return paymentArrayList;
    }

    public void setPaymentArrayList(ArrayList<Payment> paymentArrayList) {
        this.paymentArrayList = paymentArrayList;
    }

    // add and remove methods for the above arraylist
    public boolean addPayment(Payment p){
        return (this.paymentArrayList.add(p));
    }

    public boolean removePayment(Payment p){
        return (this.paymentArrayList.remove(p));
    }
}

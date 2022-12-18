import java.util.ArrayList;

public class Repository {
    private double remainingStock;
    private ArrayList<DateAndTime> dateandTimeArrayList = new ArrayList<>();

    public Repository() {
        // constructor
        remainingStock = 25000;
    }

    // getters and setters
    public double getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(double remainingStock) {
        this.remainingStock = remainingStock;
    }

    public ArrayList<DateAndTime> getDateandTimeArrayList() {
        return dateandTimeArrayList;
    }

    public void setDateandTimeArrayList(ArrayList<DateAndTime> dateandTimeArrayList) {
        this.dateandTimeArrayList = dateandTimeArrayList;
    }

    // add and remove methods for the above arraylist
    public boolean addDateandTime(DateAndTime d){
        return (this.dateandTimeArrayList.add(d));
    }

    public boolean removeDateandTime(DateAndTime d){
        return (this.dateandTimeArrayList.remove(d));
    }
}


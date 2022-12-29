import java.util.ArrayList;

public class Repository {
    private double remainingStock;
    private ArrayList<DateandTime> dateandTimeArrayList = new ArrayList<>();

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

    public ArrayList<DateandTime> getDateandTimeArrayList() {
        return dateandTimeArrayList;
    }

    public void setDateandTimeArrayList(ArrayList<DateandTime> dateandTimeArrayList) {
        this.dateandTimeArrayList = dateandTimeArrayList;
    }

    // add and remove methods for the above arraylist
    public boolean addDateandTime(DateandTime d){
        return (this.dateandTimeArrayList.add(d));
    }

    public boolean removeDateandTime(DateandTime d){
        return (this.dateandTimeArrayList.remove(d));
    }
}

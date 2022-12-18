import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class system {
    private int systemId;
    private ArrayList<Queue> queueArrayList = new ArrayList<>();
    private ArrayList<Ticket> ticketArrayList = new ArrayList<>();

    public system() throws ClassNotFoundException, SQLException {

    }

    public void totalVehicles() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement = connection.createStatement();

        String query1 = "select count(*) from customer WHERE fuel_type = 'petrol'";
        ResultSet resultSet = statement.executeQuery(query1);
        resultSet.next();
        int rows = resultSet.getInt(1);
        System.out.println("total vehicles served in petrol repositories : " + rows);
    }

    public void totalVehiclesDiesel() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String query2 = "select count(*) from customer WHERE fuel_type = 'diesel'";
        ResultSet resultSet = stmt.executeQuery(query2);
        resultSet.next();
        int rows = resultSet.getInt(1);
        System.out.println("total vehicles served in diesel repositories : " + rows);
    }

    public void largeAmount() throws ClassNotFoundException, SQLException {
        int amount = 0;
        String qrLarge = "";
        ArrayList<Integer> amounts = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement=connection.createStatement();

        String test = "SELECT fuel_amount FROM customer";
        ResultSet resultSet = statement.executeQuery(test);
        while (resultSet.next()) {
            amount = resultSet.getInt("fuel_amount");
            amounts.add(amount);
        }
        int maxVal = Collections.max(amounts);
        int indexOfMax = amounts.indexOf(maxVal);

        Statement statement1 = connection.createStatement ();
        statement1.executeQuery ("SELECT qr_no FROM customer");
        ResultSet resultSet1 = statement1.getResultSet ();

        for (int i = 0; i < indexOfMax + 1; i++){
            resultSet1.next();
            qrLarge = resultSet1.getString("qr_no");
        }
        System.out.println("QR number of largest fuel pumped vehicle is : " + qrLarge);
    }

    public void largeAmountdiesel() throws ClassNotFoundException, SQLException {
        int amount = 0;
        String qrLarge = "";
        ArrayList<Integer> amounts = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement=connection.createStatement();

        String test = "SELECT diesel_fuel_amount FROM customer";
        ResultSet resultSet = statement.executeQuery(test);
        while (resultSet.next()) {
            amount = resultSet.getInt("diesel_fuel_amount");
            amounts.add(amount);
        }
        int maxVal = Collections.max(amounts);
        int indexOfMax = amounts.indexOf(maxVal);

        Statement statement1 = connection.createStatement ();
        statement1.executeQuery ("SELECT qr_no FROM customer");
        ResultSet resultSet1 = statement1.getResultSet ();

        for (int i = 0; i < indexOfMax + 1; i++){
            resultSet1.next();
            qrLarge = resultSet1.getString("qr_no");
        }
        System.out.println("QR number of largest fuel pumped vehicle is : " + qrLarge);
    }

    public void remainingStock() throws ClassNotFoundException, SQLException {
        int remainingStock = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement=connection.createStatement();

        String test = "SELECT remaining_repositories FROM customer WHERE fuel_type = 'petrol'";
        ResultSet resultSet = statement.executeQuery(test);
        while (resultSet.next()) {
            if (resultSet.isLast()){
                remainingStock = resultSet.getInt("remaining_repositories");
                System.out.println("Remaining stock for petrol is : " + remainingStock);
            }
        }
    }

    public void remainingStockDiesel() throws ClassNotFoundException, SQLException {
        int remainingStock = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement=connection.createStatement();

        String test = "SELECT remaing_diesel_stock FROM customer WHERE fuel_type = 'diesel'";
        ResultSet resultSet = statement.executeQuery(test);
        while (resultSet.next()) {
            if (resultSet.isLast()){
                remainingStock = resultSet.getInt("remaing_diesel_stock");
                System.out.println("Remaining stock for diesel is : " + remainingStock);
            }
        }
    }

    // getters and setters
    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public ArrayList<Queue> getQueueArrayList() {
        return queueArrayList;
    }

    public void setQueueArrayList(ArrayList<Queue> queueArrayList) {
        this.queueArrayList = queueArrayList;
    }

    public ArrayList<Ticket> getTicketArrayList() {
        return ticketArrayList;
    }

    public void setTicketArrayList(ArrayList<Ticket> ticketArrayList) {
        this.ticketArrayList = ticketArrayList;
    }

    // add and remove methods for the above arraylist
    public boolean addQueue(Queue q){
        return (this.queueArrayList.add(q));
    }

    public boolean removeQueue(Queue q){
        return (this.queueArrayList.remove(q));
    }

    public boolean addTicket(Ticket t){
        return (this.ticketArrayList.add(t));
    }

    public boolean removeTicket(Ticket t){
        return (this.ticketArrayList.remove(t));
    }
}


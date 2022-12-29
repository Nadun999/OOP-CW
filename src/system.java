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
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String query2 = "select count(*) from customer WHERE f_type = 'petrol'";
        ResultSet rs0 = stmt.executeQuery(query2);
        rs0.next();
        int raws = rs0.getInt(1);
        System.out.println("total vehicles served in petrol repositories : " + raws);
    }

    public void totalVehiclesDiesel() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String query2 = "select count(*) from customer WHERE f_type = 'diesel'";
        ResultSet rs0 = stmt.executeQuery(query2);
        rs0.next();
        int raws = rs0.getInt(1);
        System.out.println("total vehicles served in diesel repositories : " + raws);
    }

    public void largeAmount() throws ClassNotFoundException, SQLException {
        int amount = 0;
        String qrLarge = "";
        ArrayList<Integer> amounts = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT f_amount FROM customer";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            amount = rs.getInt("f_amount");
            amounts.add(amount);
        }
        int maxVal = Collections.max(amounts);
        int indexOfMax = amounts.indexOf(maxVal);

        Statement s = conn.createStatement ();
        s.executeQuery ("SELECT qr_no FROM customer");
        ResultSet rs2 = s.getResultSet ();

        for (int i = 0; i < indexOfMax + 1; i++){
            rs2.next();
            qrLarge = rs2.getString("qr_no");
        }
        System.out.println("QR number of largest fuel pumped vehicle is : " + qrLarge);
    }

    public void largeAmountdiesel() throws ClassNotFoundException, SQLException {
        int amount = 0;
        String qrLarge = "";
        ArrayList<Integer> amounts = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT diesel_amount FROM customer";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            amount = rs.getInt("diesel_amount");
            amounts.add(amount);
        }
        int maxVal = Collections.max(amounts);
        int indexOfMax = amounts.indexOf(maxVal);

        Statement s = conn.createStatement ();
        s.executeQuery ("SELECT qr_no FROM customer");
        ResultSet rs2 = s.getResultSet ();

        for (int i = 0; i < indexOfMax + 1; i++){
            rs2.next();
            qrLarge = rs2.getString("qr_no");
        }
        System.out.println("QR number of largest fuel pumped vehicle is : " + qrLarge);
    }

    public void remainingStock() throws ClassNotFoundException, SQLException {
        int remainingStock = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT remaining_repos FROM customer WHERE f_type = 'petrol'";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            if (rs.isLast()){
                remainingStock = rs.getInt("remaining_repos");
                System.out.println("Remaining stock for petrol is : " + remainingStock);
            }
        }
    }

    public void remainingStockDiesel() throws ClassNotFoundException, SQLException {
        int remainingStock = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT remaining_diesel_repos FROM customer WHERE f_type = 'diesel'";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            if (rs.isLast()){
                remainingStock = rs.getInt("remaining_diesel_repos");
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

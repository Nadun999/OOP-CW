import java.sql.*;
import java.util.ArrayList;

public class MainQueue extends Queue implements Runnable{
    private  int queueLength;
    // getters and setters
    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    public MainQueue() throws ClassNotFoundException, SQLException {

    }

    public void run() {
        for (int i = 0; i<=1000; i++){
            // creating database connection
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Statement stmt= null;
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            ResultSet rs = null;
            try {
                rs = stmt.executeQuery("SELECT * FROM customer");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rs.absolute(2);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rs.deleteRow();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void checkTicket(){
        // this method is used to check whether the customer has a ticket
    }

    public static void checkVehicle() throws SQLException, ClassNotFoundException {

    }
}

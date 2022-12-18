import java.sql.*;

public class Payment {
    private String paymentMethod;
    private double payment;

    // getters and setters
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void PaymentforOctane() throws ClassNotFoundException, SQLException {
        double totalPayment = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT amount FROM customer WHERE fuel_type = 'petrol'";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            totalPayment = totalPayment + rs.getInt("amount");
        }
        System.out.println("total payment : " + totalPayment);
    }

    public void paymentForDiesel() throws ClassNotFoundException, SQLException {
        double totalPayment = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String mvmt = "SELECT amount FROM customer WHERE fuel_type = 'diesel'";
        ResultSet rs = stmt.executeQuery(mvmt);
        while (rs.next()) {
            totalPayment = totalPayment + rs.getInt("amount");
        }
        System.out.println("total payment in diesel repositories : " + totalPayment);
    }
}

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
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=conn.createStatement();

        String test = "SELECT amount FROM customer WHERE f_type = 'petrol'";
        ResultSet rs = stmt.executeQuery(test);
        while (rs.next()) {
            totalPayment = totalPayment + rs.getInt("amount");
        }
        System.out.println("total payment : " + totalPayment);
    }

    public void paymentForDiesel() throws ClassNotFoundException, SQLException {
        double totalamount = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement stmt=connection.createStatement();

        String test = "SELECT amount FROM customer WHERE f_type = 'diesel'";
        ResultSet resultSet = stmt.executeQuery(test);
        while (resultSet.next()) {
            totalamount = totalamount + resultSet.getInt("amount");
        }
        System.out.println("total payment in diesel repositories : " + totalamount);
    }
}

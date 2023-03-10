import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Queue{
    private int totalPrice;
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    public Queue() {
        // constructor
    }

    // getters and setters
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    // add and remove methods for the above arraylist
    public boolean addCustomer(Customer c){
        return (this.customerArrayList.add(c));
    }

    public boolean removeCustomer(Customer c){
        return (this.customerArrayList.remove(c));
    }

    public void addingCustomer() throws ClassNotFoundException, SQLException{
        // creating database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root", "Nadun@123");
        Statement statement=conn.createStatement();
        Statement statement2=conn.createStatement();
        Statement statement3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = " insert into customer (v_type,f_type,qr_no, f_amount,payment_method,amount,t_id,c_id,date_time,remaining_repos,remaining_diesel_repos,diesel_amount)"+ " values (?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);

        int remainingStock = 0;
        int remainingStockD = 0;

        ResultSet rs0 = statement3.executeQuery("SELECT * FROM customer");
        rs0.absolute(-1);
        // Get data at cursor
        int currentId = rs0.getInt("c_id");
        int count = currentId + 1;

        // creating objects
        Customer newCustomer = new Customer();
        Ticket tickets = new Ticket();
        Payment paymentdetails = new Payment();
        Repository repositoryDetails = new Repository();
        Worker paymentTrack = new Worker();
        Management trackAvailability = new Management();



        String choice = "yes";

        while (choice.equals("yes")){

            String mvmt = "SELECT remaining_repos FROM customer";
            ResultSet rs = statement.executeQuery(mvmt);
            while (rs.next()) {
                if (rs.isLast()){
                    remainingStock = rs.getInt("remaining_repos");
                    System.out.println("remaining stock for octane is : " + remainingStock);
                }
            }

            String mvmt2 = "SELECT remaining_diesel_repos FROM customer";
            ResultSet rs2 = statement2.executeQuery(mvmt2);
            while (rs2.next()) {
                if (rs2.isLast()){
                    remainingStockD = rs2.getInt("remaining_diesel_repos");
                    System.out.println("remaining stock for diesel is : " + remainingStockD);
                }
            }

            Scanner csn = new Scanner(System.in);
            Scanner scn = new Scanner(System.in);
            Scanner scn2 = new Scanner(System.in);
            Scanner tot = new Scanner(System.in);

            // getting vehicle type from customer
            System.out.print("Add the vehicle type : ");
            String vehicleType = csn.nextLine();
            newCustomer.setVehicleType(vehicleType);

            // getting fuel type from customer
            System.out.print("Add your fuel type : ");
            String fuelType = scn.nextLine();
            newCustomer.setFuelType(fuelType);

            // getting qr from customer
            System.out.print("Add your QR : ");
            int qrType = scn.nextInt();
            newCustomer.setQrNumber(qrType);

            // assigning an id number to each customer
            newCustomer.setIdNo(count);

            // assigning ticket number to each customer
            tickets.setTicketNo(count);

            // getting payment method from customer
            System.out.print("Add your payment method : ");
            String payMethod = tot.nextLine();
            paymentdetails.setPaymentMethod(payMethod);

            // getting needed fuel amount from customer
            int totPrice = 0;
            System.out.print("How much fuel do you want : ");
            int fuelAmount = scn.nextInt();
            // updating available stocks
            double availableStock = repositoryDetails.getRemainingStock();
            if (availableStock > 500){
                repositoryDetails.setRemainingStock(availableStock - fuelAmount);
                if (fuelType.equals("petrol")){
                    totPrice = fuelAmount * 450;
                } else if (fuelType.equals("diesel")) {
                    totPrice = fuelAmount * 430;
                }
                // set availability
                trackAvailability.setAvailability(true);
                paymentdetails.setPayment(totPrice);
                setTotalPrice(totPrice);
                System.out.println("total price : " + getTotalPrice());

                // updating payment array list
                ArrayList<Payment> singlePayment = new ArrayList<>();
                singlePayment.add(paymentdetails);
                paymentTrack.setPaymentArrayList(singlePayment);
            }

            // updating customer table
            ps.setString(1,vehicleType);
            ps.setString(2,fuelType);
            ps.setInt(3,qrType);
            if (fuelType.equals("petrol")){
                ps.setInt(4,fuelAmount);
                ps.setInt(12,0);
            } else if (fuelType.equals("diesel")) {
                ps.setInt(4,0);
                ps.setInt(12,fuelAmount);
            }
            ps.setString(5,payMethod);
            ps.setInt(6,totalPrice);
            ps.setInt(7,count);
            ps.setInt(8,count);
            ps.setString(9,"05/08/2022");
            if (fuelType.equals("petrol")){
                ps.setInt(10, remainingStock - fuelAmount);
                ps.setInt(11, remainingStockD);
            } else if (fuelType.equals("diesel")) {
                ps.setInt(11, remainingStockD - fuelAmount);
                ps.setInt(10, remainingStock);
            }


            ps.executeUpdate();

            while (rs.next()) {
                if (rs.isLast()){
                    remainingStock = rs.getInt("remaining_repos");
                    System.out.println("remaining stock for octane is : " + remainingStock);
                }
            }

            while (rs2.next()) {
                if (rs2.isLast()){
                    remainingStockD = rs2.getInt("remaining_diesel_repos");
                    System.out.println("remaining stock for diesel is : " + remainingStockD);
                }
            }




            count += 1;

            System.out.print("Are there more customers in the station ? (yes/no) : ");
            choice = scn2.nextLine();
        }

        statement.close();
        statement2.close();
        conn.close();

        // adding new customer to customer array list
        customerArrayList.add(newCustomer);

        // decreasing ticket count by one
        tickets.setTicketCount(tickets.getTicketCount() - 1);
        count += 1;
    }
}

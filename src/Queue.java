import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Queue {
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

    public void addingCustomer() throws ClassNotFoundException, SQLException {
        // creating database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOD","root", "Nadun@123");
        Statement statement_1=connection.createStatement();
        Statement statement_2=connection.createStatement();
        String query = " insert into customer (vehicle_type,fuel_type,qr_no, fuel_amount,payment_method,amount,ticket_id,customer_id,date_time,remaining_repositories,remaning_petrol_stock,remaing_diesel_stock)"+ " values (?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        int remainingPetrolRepositories = 0;
        int remainingDieselRepositories = 0;

        String query2 = "select count(*) from customer";
        ResultSet resultSet = statement_1.executeQuery(query2);
        resultSet.next();
        int count = 0;
        int rows = resultSet.getInt(1);
        if (rows > 1){
            count = rows+1;
        }else {
            count = 1;
        }
        System.out.println("row count is : " + rows);

        // creating objects
        Customer newCustomer = new Customer();
        Ticket tickets = new Ticket();
        Payment paymentDetails = new Payment();
        Repository repositoryDetails = new Repository();
        Worker paymentTrack = new Worker();
        Management trackAvailability = new Management();


        String choice = "yes";
        while (choice.equals("yes")){

            String test = "SELECT remaining_repositories FROM customer";
            ResultSet resultset_2 = statement_1.executeQuery(test);
            while (resultset_2.next()) {
                if (resultset_2.isLast()){
                    remainingPetrolRepositories = resultset_2.getInt("remaining_repositories");
                    System.out.println("remaining stock for octane is : " + remainingPetrolRepositories);
                }
            }

            String test2 = "SELECT remaing_diesel_stock FROM customer";
            ResultSet resultset3 = statement_2.executeQuery(test2);
            while (resultset3.next()) {
                if (resultset3.isLast()){
                    remainingDieselRepositories = resultset3.getInt("remaing_diesel_stock");
                    System.out.println("remaining stock for diesel is : " + remainingDieselRepositories);
                }
            }

            Scanner a = new Scanner(System.in);
            Scanner b = new Scanner(System.in);
            Scanner c = new Scanner(System.in);
            Scanner d = new Scanner(System.in);

            // getting vehicle type from customer
            System.out.print("What is your vehicle type ? ");
            String vehicleType = a.nextLine();
            newCustomer.setVehicleType(vehicleType);

            // getting fuel type from customer
            System.out.print("What is your vehicle's fuel type ? ");
            String fuelType = b.nextLine();
            newCustomer.setFuelType(fuelType);

            // getting qr from customer
            System.out.print("Add your QR here: ");
            int qr_no = b.nextInt();
            newCustomer.setQrNumber(qr_no);

            // assigning an id number to each customer
            newCustomer.setIdNo(count);

            // assigning ticket number to each customer
            tickets.setTicketNo(count);

            // getting payment method from customer
            System.out.print("What is your payment method ? ");
            String paymentMethod = d.nextLine();
            paymentDetails.setPaymentMethod(paymentMethod);

            // getting needed fuel amount from customer
            int totalPrice = 0;
            System.out.print("How much fuel do you want ? ");
            int fuelCount = b.nextInt();
            // updating available stocks
            double availableStock = repositoryDetails.getRemainingStock();
            if (availableStock > 500){
                repositoryDetails.setRemainingStock(availableStock - fuelCount);
                if (fuelType.equals("petrol")){
                    totalPrice = fuelCount * 450;
                } else if (fuelType.equals("diesel")) {
                    totalPrice = fuelCount * 430;
                }
                // set availability
                trackAvailability.setAvailability(true);
                paymentDetails.setPayment(totalPrice);
                setTotalPrice(totalPrice);
                System.out.println("total price : " + getTotalPrice());

                // updating payment array list
                ArrayList<Payment> singlePayment = new ArrayList<>();
                singlePayment.add(paymentDetails);
                paymentTrack.setPaymentArrayList(singlePayment);
            }

            // updating customer table
            preparedStatement.setString(1,vehicleType);
            preparedStatement.setString(2,fuelType);
            preparedStatement.setInt(3,qr_no);
            if (fuelType.equals("petrol")){
                preparedStatement.setInt(4,fuelCount);
                preparedStatement.setInt(12,0);
            } else if (fuelType.equals("diesel")) {
                preparedStatement.setInt(4,0);
                preparedStatement.setInt(12,fuelCount);
            }
            preparedStatement.setString(5,paymentMethod);
            preparedStatement.setInt(6, this.totalPrice);
            preparedStatement.setInt(7,count);
            preparedStatement.setInt(8,count);
            preparedStatement.setString(9,"05/08/2022");
            if (fuelType.equals("petrol")){
                preparedStatement.setInt(10, remainingPetrolRepositories - fuelCount);
                preparedStatement.setInt(11, remainingDieselRepositories);
            } else if (fuelType.equals("diesel")) {
                preparedStatement.setInt(11, remainingDieselRepositories - fuelCount);
                preparedStatement.setInt(10, remainingPetrolRepositories);
            }

            preparedStatement.executeUpdate();

            while (resultset3.next()) {
                if (resultset3.isLast()){
                    remainingPetrolRepositories = resultset3.getInt("remaining_repositories");
                    System.out.println("r" +
                            "Remaining stock for octane is : " + remainingPetrolRepositories);
                }
            }

            while (resultset3.next()) {
                if (resultset3.isLast()){
                    remainingDieselRepositories = resultset3.getInt("remaing_diesel_stock");
                    System.out.println("Remaining stock for diesel is : " + remainingDieselRepositories);
                }
            }

            count += 1;

            System.out.print("Are there more customers in the station ? (yes/no) : ");
            choice = c.nextLine();
        }

        statement_1.close();
        statement_2.close();
        connection.close();

        // adding new customer to customer array list
        customerArrayList.add(newCustomer);
//        System.out.println("first vehicle on queue : " + customerArrayList.get(0).getVehicleType());

        // decreasing ticket count by one
        tickets.setTicketCount(tickets.getTicketCount() - 1);
//        System.out.println("tickets left : " + tickets.getTicketCount());
//        System.out.println("remaining fuel count : " + repositoryDetails.getRemainingStock());
        count += 1;
    }
}


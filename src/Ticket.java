public class Ticket {
    private int ticketNo;
    private int ticketCount;
    // getters and setters
    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Ticket() {
        // constructor
        ticketCount = 500;
    }
}

public class DateAndTime {
    // getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DateAndTime() {
        date = "07/12/2022";
    }

    private String date;
    private String time;
}

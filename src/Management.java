public class Management {
    private boolean availability;

    // getters and setters
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Management() {
        // constructor
    }

    public void refillRepo(){
        Repository repositoryDetails = new Repository();
        double stock = repositoryDetails.getRemainingStock();
        if (stock < 500){
            // refill stock
        } else if (stock > 500) {
            // continue
        }
    }
}

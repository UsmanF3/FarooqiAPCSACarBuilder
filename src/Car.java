public class Car {
    public int cost;
    public String engineInfo;
    public int seats;
    public String name;
    public String drivetrain;

    public Car(int seats, String name, String drivetrain, int cost, String engineInfo) {
        this.seats = seats;
        this.name = name;
        this.drivetrain = drivetrain;
        this.cost = cost;
        this.engineInfo = engineInfo;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getEngineInfo() {
        return engineInfo;
    }

    public int getSeats() {
        return seats;
    }

    public String getDrivetrain() {
        return drivetrain;
    }
}

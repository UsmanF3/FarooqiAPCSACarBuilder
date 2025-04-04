public class Sedan extends Car{
    public Sedan(String name, String drivetrain, int cost, String engineInfo) {
        super(5, name, drivetrain, cost, engineInfo);
    }

    @Override
    public int getSeats() {
        return 5;
    }
}

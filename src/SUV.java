public class SUV extends Car{
    public SUV(String name, String drivetrain, int cost, String engineInfo) {
        super(8, name, drivetrain, cost, engineInfo);
    }

    @Override
    public int getSeats() {
        return 8;
    }
}

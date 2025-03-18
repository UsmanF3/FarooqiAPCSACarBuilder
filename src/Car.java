public class Car {
    public int price;
    public int seats;
    public String make;
    public String model;
    public String color;

    public Car(int seats, String make, String model, String color) {
        this.seats = seats;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}

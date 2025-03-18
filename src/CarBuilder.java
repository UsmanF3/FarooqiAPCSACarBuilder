import java.util.Scanner;

public class CarBuilder {
    public Scanner scan;
    public String name;
    public String make;
    public String model;
    public String color;

    public CarBuilder() {
        scan = new Scanner(System.in);
        name = "";
    };

    public void run() {
        prompt();
    }

    private void prompt() {
        System.out.print("Welcome to the Car Builder! Enter your name here: ");
        name = scan.nextLine();
        System.out.print("Hi " + name + "! Enter the make (manufacturer) of your car here: ");
        make = scan.nextLine();
        System.out.print("Enter the model (type) of your car here: ");
        model = scan.nextLine();
        System.out.print("What color is the exterior of your car?");
        color = scan.nextLine();
    }

}

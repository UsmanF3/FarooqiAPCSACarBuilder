import java.io.*;
import java.util.*;

public class CarBuilder {
    public Scanner scan;
    public String name;
    public String make;
    public String model;
    public String color;
    private ArrayList<String> cars = new ArrayList<>();

    public CarBuilder() {
        scan = new Scanner(System.in);
        name = "";
    };

    public void run() {
        importData();
        prompt();
    }

    public void importData() {
        try {
            File myFile = new File("src\\cars.csv");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                cars.add(data);
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void prompt() {
        System.out.print("Welcome to the Car Builder! Enter your name here: ");
        name = scan.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.print("Hi " + name + "! ");
        boolean bool = false;
        while (!bool) {
            bool = searchCar();
        }
    }

    private void buildCar(String car, String type, String drivetrain, int cost, String engineInfo) {
        Car whip;
        if (type.equals("Sedan")||type.equals("Sports Car")) {
            whip = new Sedan(car, drivetrain, cost, engineInfo);
        } else {
            whip = new SUV(car, drivetrain, cost, engineInfo);
        }
        System.out.print("\nEnter the color of your car: ");
        String color = scan.nextLine().toLowerCase();
        while (!(color.equals("red"))&&!(color.equals("orange"))&&!(color.equals("yellow"))&&!(color.equals("green"))&&!(color.equals("blue"))&&!(color.equals("purple"))&&!(color.equals("pink"))&&!(color.equals("grey"))&&!(color.equals("white"))&&!(color.equals("black"))) {
            System.out.println("Not a valid color! Try again!");
            System.out.print("Enter the color of your car: ");
            color = scan.nextLine().toLowerCase();
        }
        System.out.print("\nBuilding your car");
        for (int i = 0; i<3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        JFrameOne frame = new JFrameOne(whip, color);
    }

    private void giveInfo(String carInfo) {
        String inf = carInfo;
        String drivetrain = null;
        String[] infoArray = new String[9];
        for (int i = 0; i < 9; i++) {
            infoArray[i]=inf.substring(0, inf.indexOf(","));
            inf = inf.substring(inf.indexOf(",")+1);
        }
        System.out.println("Car: " + infoArray[0]);
        System.out.println("Type: " + infoArray[1]);
        if (Objects.equals(infoArray[2], "0") && Objects.equals(infoArray[3], "0")) {
            System.out.println("Drivetrain: FWD");
            drivetrain = "FWD";
        } else if (Objects.equals(infoArray[2], "1")) {
            System.out.println("Drivetrain: AWD");
            drivetrain = "AWD";
        } else {
            System.out.println("Drivetrain: RWD");
            drivetrain = "RWD";
        }
        int rough = (int) (1.30*((Integer.parseInt(infoArray[4]) + Integer.parseInt(infoArray[5]))/2));
        System.out.println("Rough Cost Estimate: $" + rough);
        String engineInformation = "Engine Info: " + infoArray[6] + " liter, " + infoArray[7] + " cylinder making " + infoArray[8] + " horsepower";
        System.out.println(engineInformation);
        System.out.print("\nIs this the car you want to select for your build? (y/n): ");
        String say = scan.nextLine();
        if (say.equals("y")) {
            buildCar(infoArray[0], infoArray[1], drivetrain, rough, engineInformation);
        } else if (say.equals("n")) {
            System.out.println("Choose again!");
            searchCar();
        } else {
            System.out.println("Invalid choice");
        }

    }

    private boolean searchCar() {
        System.out.print("Enter a title search term: ");
        String input = scan.nextLine();
        input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        ArrayList<String> titles = new ArrayList<>();
        for (String car : cars) {
            if (car.toUpperCase().contains(input.toUpperCase())) {
                titles.add(car);
            }
        }
        for (int i = 1; i < titles.size(); i++) {
            String num = titles.get(i);
            int idx = i;
            while (idx != 0 && titles.get(idx - 1).compareTo(num) > 0) {
                titles.set(idx, titles.get(idx - 1));
                idx--;
            }
            titles.set(idx, num);
        }
        int counter = 0;
        for (String title : titles) {
            counter++;
            System.out.println(counter + ": " + title.substring(0, title.indexOf(",")));
        }
        if (titles.isEmpty()) {
            System.out.println("No car titles match that search term!\n");
            return false;
        } else {
            System.out.print("Which car would you like to learn more about?\nEnter Number: ");
            int userInp = scan.nextInt();
            scan.nextLine();
            String name = titles.get(userInp - 1);
            System.out.println();
            giveInfo(name);
        }
        return true;
    }

}

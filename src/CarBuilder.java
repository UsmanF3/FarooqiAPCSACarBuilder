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
        for (String car : cars) {
            System.out.println(car);
        }
    }

    private void prompt() {
        System.out.print("Welcome to the Car Builder! Enter your name here: ");
        name = scan.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        System.out.print("Hi " + name + "! Enter the make (manufacturer) of your car here: ");
        searchCar();
        /*make = scan.nextLine();
        make = make.substring(0, 1).toUpperCase() + make.substring(1).toLowerCase();
        System.out.print("Enter the model (type) of your car here: ");
        model = scan.nextLine();
        model = model.substring(0, 1).toUpperCase() + model.substring(1).toLowerCase();
        System.out.print("What color is the exterior of your car? Enter here: ");
        color = scan.nextLine();
        color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
        System.out.println("Your car is a " + color + " " + make + " " + model + "?");*/
    }

    private void searchCar() {
        System.out.print("Enter a title search term: ");
        String input = scan.nextLine();
        input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        ArrayList<String> titles = new ArrayList<>();
        for (String car : cars) {
            if (car.contains(input)) {
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
            System.out.println("\nNo car titles match that search term!");
        } else {
            System.out.print("Which movie would you like to learn more about?\nEnter Number: ");
            int userInp = scan.nextInt();
            scan.nextLine();
            String name = titles.get(userInp - 1);

        }
    }

}

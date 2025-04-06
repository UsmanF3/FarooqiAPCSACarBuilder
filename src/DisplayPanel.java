import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener {

    // add button as instance variable
    private String message;
    private JLabel imageLabel;
    private JButton button;
    private JButton infoButton;
    private Car car;
    private String[][] suggestions = {
            {"The car is going to be heavier than others, but that's why it's conventionally more powerful", "Since the car is more sizeable, it's good for larger families and longer drives", "You may need to drive a little more careful since the car is larger than others"},
            {"The car is conventionally a little less powerful than others, but the lightweight factor makes it up", "Since the car is more compact than others, it has much better handling and control", "Since the car is smaller than others, it's not convenient to seat as many people as others or store items"}
    };

    public DisplayPanel(Car car) {
        this.car = car;
        message = "Click the button!";
        // create a new JButton component
        button = new JButton("More Info");
        button.addActionListener(this);
        // call add method (inherited from JPanel) to add
        // the JButton component to the DisplayPanel
        add(button);
        infoButton = new JButton("Generate Image!");
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = "This car was assembled using premium components!";
                imageLabel.setVisible(true);
                repaint();
            }
        });
        add(infoButton);

        ImageIcon carImage = new ImageIcon("src/cars/blacksedan.png"); // replace with correct path
        Image image = carImage.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH); // resize the image to 300x300 pixels
        carImage = new ImageIcon(image); // wrap it back into ImageIcon

        imageLabel = new JLabel(carImage);
        imageLabel.setVisible(false); // initially hidden
        add(imageLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.RED);
        g.drawString("Car Builder!", 420, 55);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Car: " + car.name, 50, 100);
        g.drawString("Seats: " + car.seats, 50, 130);
        g.drawString("Drivetrain: " + car.drivetrain, 50, 160);
        g.drawString("Cost Estimate $: " + (int) (1.1*car.cost), 50, 190);
        g.drawString(car.engineInfo, 50, 220);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString(message, 220, 730);

        // set location of where button gets drawn on the screen
        // (keep in mind +y is DOWN, so this appears UNDER the message)
        button.setLocation(450, 680);
        infoButton.setLocation(750, 340);

        imageLabel.setLocation(50, 250); // change as needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int rand = (int) (Math.random()*3);
        if (car.getSeats()==5) {
            message = suggestions[1][rand];
        } else {
            message = suggestions[0][rand];
        }
        repaint();
    }
}
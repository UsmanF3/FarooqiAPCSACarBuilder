import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener {

    // add button as instance variable
    private JButton button;

    public DisplayPanel(Car car) {

        // create a new JButton component
        button = new JButton("Click me");
        button.addActionListener(this);
        // call add method (inherited from JPanel) to add
        // the JButton component to the DisplayPanel
        add(button);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Car Builder!", 300, 30);
        g.drawString("Car Builder!", 300, 30);

        // set location of where button gets drawn on the screen
        // (keep in mind +y is DOWN, so this appears UNDER the message)
        button.setLocation(300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //make image visible
    }
}
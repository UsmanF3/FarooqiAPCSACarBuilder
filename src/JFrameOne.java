import javax.swing.JFrame;

public class JFrameOne {

    public JFrameOne(Car car, String color) {
        JFrame frame = new JFrame("Frame title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        DisplayPanel panel = new DisplayPanel(car, color);
        frame.add(panel);
        frame.setVisible(true);
    }
}
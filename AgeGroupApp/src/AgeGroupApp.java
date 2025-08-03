import javax.swing.*;
import java.awt.*; 

public class AgeGroupApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Group Identifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

      
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); 

       
        frame.add(panel);
        frame.setVisible(true);
    }
}
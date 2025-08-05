import javax.swing.*;
import java.awt.*;

public class AgeGroupApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Group Identifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 370); 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        Font font = new Font("Segoe UI", Font.PLAIN, 16);
        
        JLabel ageLabel = new JLabel("Enter your age:");
        ageLabel.setFont(font);
        
        JTextField ageInput = new JTextField(5);        
        JButton checkButton = new JButton("Check");
        JButton resetButton = new JButton("Reset");
        
        JTextArea resultArea = new JTextArea(12, 30); 
        resultArea.setFont(font);
        resultArea.setEditable(false); 
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true); 
        JScrollPane scrollPane = new JScrollPane(resultArea); 

        panel.add(ageLabel);
        panel.add(ageInput);
        panel.add(checkButton);
        panel.add(resetButton);
        panel.add(scrollPane);

        
        frame.add(panel);
        frame.setVisible(true);
    }
}

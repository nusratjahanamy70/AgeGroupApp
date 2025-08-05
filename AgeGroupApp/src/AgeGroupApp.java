import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = ageInput.getText();
                try {
                    int age = Integer.parseInt(inputText);
                    
                    if (age <= 0 || age > 150) {
                        resultArea.setText("Please enter a valid number!");
                        return;
                    }
                    
                    String[] ageGroupInfo = determineAgeGroup(age);
                    
                    String output = "Age Group: " + ageGroupInfo[0] + "\n" +
                                   "Workout: " + ageGroupInfo[1] + "\n";
                    
                    resultArea.setText(output); 
                } catch (NumberFormatException ex) {
                    resultArea.setText("Please enter a valid number!");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ageInput.setText("");
                resultArea.setText(""); 
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static String[] determineAgeGroup(int age) {
        String ageGroup, workout;

        if (age <= 12) {
            ageGroup = "Child.\n";
            workout = " Encourage at least 60 minutes of physical activity daily:\n- Active play like running, jumping, cycling.\n- Games that develop coordination and balance.\n- Limit screen time to promote movement.\n";
        } else if (age <= 19) {
            ageGroup = "Teenager\n";
            workout = " Support growing bodies with structured activity:\n- Team sports (football, cricket, basketball).\n- Basic strength training (bodyweight exercises).\n- At least 60 minutes of moderate-to-intense activity daily.\n";
        } else if (age <= 64) {
            ageGroup = "Adult\n";
            workout = " Maintain fitness and reduce stress:\n- At least 150 minutes of moderate aerobic activity per week.\n- Strength training (2–3 days a week).\n- Mix of walking, cycling, swimming, or yoga.\n";
        } else {
            ageGroup = "Senior\n";
            workout = " Stay active while protecting joints:\n- Daily walking or light stretching.\n- Chair yoga, tai chi, or water aerobics.\n- Focus on flexibility, balance, and light strength.\n";
        }

        return new String[]{ageGroup, workout};
    }
}


        
      

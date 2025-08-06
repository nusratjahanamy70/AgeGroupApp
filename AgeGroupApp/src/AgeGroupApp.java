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
        
       
        checkButton.setBackground(Color.GREEN);
        checkButton.setForeground(Color.BLACK);
        
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);
        
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
                    
                    String output ="Age Group: " + ageGroupInfo[0] + "\n" +
                                   "Workout: " + ageGroupInfo[1] + "\n" +
                                   "Diet: " + ageGroupInfo[2] + "\n" +
                                   "Hydration: " + ageGroupInfo[3];
                    
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
        String ageGroup, workout, diet, hydration;

        if (age <= 12) {
            ageGroup = "Child.\n";
            workout = "Promote 60 minutes of daily activity with active play, coordination games, and reduced screen time.\n";
            diet = "Focus on growth with fruits, veggies, healthy snacks, and hydration (water or milk). Limit sugary drinks.\n";
            hydration = "Drink about 5-7 cups (1.2-1.6 liters) of water daily.\n";
        } else if (age <= 19) {
            ageGroup = "Teenager\n";
            workout = "Support growth with structured activities like team sports, bodyweight exercises, and 60 minutes of daily moderate-to-intense activity.\n";
            diet = "Fuel growth with protein (eggs, fish), calcium (milk, cheese), and limit junk food; choose homemade.\n";
            hydration = "Drink about 7-10 cups (1.6-2.4 liters) of water daily.\n";
        } else if (age <= 64) {
            ageGroup = "Adult\n";
            workout = "Achieve fitness with 150 minutes of aerobic activity weekly, strength training 2–3 days, and activities like walking or yoga.\n";
            diet = "Support health with lean proteins, whole grains, healthy fats, hydration, and limit processed foods.\n";
            hydration = "Drink about 8-12 cups (2-3 liters) of water daily.\n";
        } else {
            ageGroup = "Senior\n";
            workout = "Stay active with daily walking, light stretching, chair yoga, tai chi, or water aerobics, focusing on flexibility, balance, and light strength.\n";
            diet = "Support bone health with nutrient-dense foods, smaller meals, calcium, Vitamin D, and hydration.\n";
            hydration = "Drink about 6-8 cups (1.5-2 liters) of water daily.\n";
        }

        return new String[]{ageGroup, workout, diet, hydration};
    }
} 

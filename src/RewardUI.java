import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class RewardUI {
    private JFrame frame;
    private List<Passenger> passengers;
    private JLabel idLabel;
    private JLabel milesLabel;
    private JLabel tierLabel;
    private JLabel cancelledFlightsLabel;
    private JLabel multiplierLabel;
    private boolean flightCancelled;
    private boolean passengerComplained;

    public RewardUI(List<Passenger> passengers) {
        this.passengers = passengers;

        frame = new JFrame();
        frame.setTitle("REWARD PROGRAM");

//         Set up plane image at the top
        ImageIcon planeImage = new ImageIcon(this.getClass().getResource("aeroplane.jpg"));
        Color color = new Color(204, 255, 255);
        Color color1 = new Color(56, 15, 32);

        //one panel that contain input panel and information panel
        JPanel outerPanel1 = new JPanel(new GridLayout(1,2));
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BoxLayout(outerPanel,BoxLayout.Y_AXIS));

        // Set up header with title
        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel("WELCOME TO ADISH AIRLINE REWARD PROGRAM");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(titleLabel);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        headerPanel.setBackground(color);

        // Set up input panel with text field and search button
        JPanel inputPanel = new JPanel(new GridLayout(3,1));
        JLabel userID = new JLabel("PASSENGER ID");
        userID.setBorder(BorderFactory.createEmptyBorder(0,40,0,40));
        userID.setFont(new Font("Arial", Font.BOLD, 20));
        inputPanel.add(userID);
        JTextField input = new JTextField(10);
        input.setFont(new Font("Arial",Font.BOLD,25));
        inputPanel.add(input);
        JButton search = new JButton("Search");
        search.setFont(new Font("Arial",Font.ITALIC,20));
        inputPanel.add(search);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20,40,60,40));
        inputPanel.setBackground(Color.LIGHT_GRAY);



        // Set up panel for displaying passenger information
        JPanel infoPanel = new JPanel(new GridLayout(5, 1));
//        infoPanel.setBackground(Color.red);

        // Labels to display passenger information
        idLabel = new JLabel("Passenger ID: ");
        milesLabel = new JLabel("Miles earned this year: ");
        tierLabel = new JLabel("Tier: ");
        cancelledFlightsLabel = new JLabel("Total number of cancelled flights: ");
        multiplierLabel = new JLabel("Passenger has multiplier: ");
        idLabel.setFont(new Font("Arial",Font.BOLD,16));
        milesLabel.setFont(new Font("Arial",Font.BOLD,16));
        tierLabel.setFont(new Font("Arial",Font.BOLD,16));
        cancelledFlightsLabel.setFont(new Font("Arial",Font.BOLD,16));
        multiplierLabel.setFont(new Font("Arial",Font.BOLD,16));

        // Add labels to the info panel
        infoPanel.add(idLabel);
        infoPanel.add(milesLabel);
        infoPanel.add(tierLabel);
        infoPanel.add(cancelledFlightsLabel);
        infoPanel.add(multiplierLabel);

        infoPanel.setBorder(BorderFactory.createEmptyBorder(0,60,30,0));


        outerPanel.add(inputPanel);
        outerPanel.add(infoPanel);
        inputPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        infoPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        infoPanel.setBackground(Color.LIGHT_GRAY);
        outerPanel.setBorder(BorderFactory.createEmptyBorder(3,5,2,0));



        JPanel rulesPanel = new JPanel(new GridLayout(2,1));
        JList list = new JList(new String[]{"Reward tiers, based on miles earned / flights cancelled within a single year."," ",
                "1. Gold – 25 flight cancellations. Each cancellation is worth 1000 miles."," ",
                "2. Platinum – 50 flight cancellations. Each cancellation is worth 1000 miles."," ",
                "3. Platinum Pro – A special sub-tier of Platinum, reserved for those passengers with the",
                        "   mileage multiplier. This will earn double the miles per cancelled flight (2000 miles) for ",
                "   passengers who did not complain about flight cancellations at all throughout the year."," ",

                "4. Executive Platinum – 100 flight cancellations. Each cancellation is worth 1000 miles."," ",
                "5. Super Executive Platinum – A special sub-tier of Executive Platinum, reserved for those ",
                        "   passengers with the mileage multiplier. This will earn double the miles per cancelled flight ",
                        "   (2000 miles) for passengers who did not complain about flight cancellations at " ,
                        "   all throughout the year."
        });
        rulesPanel.add(list);
        list.setFont(new Font("Italic",Font.BOLD,13));
        list.setBorder(BorderFactory.createEmptyBorder(10,30,20,0));
        list.setBackground(Color.LIGHT_GRAY);

        outerPanel1.add(outerPanel);
        outerPanel1.add(rulesPanel);

        JPanel newUser = new JPanel(new GridLayout(10,2));
        JLabel Text = new JLabel("DID NOT FIND PASSENGER ADD HERE");
        Text.setFont(new Font("Arial",Font.BOLD,18));
        Text.setLayout(new FlowLayout(FlowLayout.CENTER));
        newUser.add(Text);

        JLabel name  = new JLabel ("PASSENGER ID");
        JTextField ID = new JTextField();
        JButton add = new JButton("ADD PASSENGER");
        JLabel question1 = new JLabel("Did flight canceled?");
        JLabel question2 = new JLabel("Did passenger complain?");
        JButton yes = new JButton("YES");
        JButton no = new JButton("NO");
        JButton yes1 = new JButton("YES");
        JButton no1 = new JButton("NO");


        newUser.add(name);
        newUser.add(ID);
        newUser.add(question1);
        newUser.add(yes);
        newUser.add(no);
        newUser.add(question2);
        newUser.add(yes1);
        newUser.add(no1);
        newUser.add(add);
        rulesPanel.add(newUser);


        newUser.setBorder(BorderFactory.createEmptyBorder(15,50,0,20));
        rulesPanel.setBorder(BorderFactory.createEmptyBorder(3,10,3,5));
        newUser.setBackground(Color.LIGHT_GRAY);

        rulesPanel.setBackground(color1);
        outerPanel.setBackground(color1);


        JPanel footer = new JPanel();
        JLabel copyRight = new JLabel("Copyright © [2024] Adish Airline Software. All rights reserved.");
        copyRight.setFont(new Font("Italic",Font.BOLD,12));
        footer.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        footer.add(copyRight);
        footer.setBackground(color);

        // Add ActionListener to search button
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve entered ID
                int enteredID;
                try {
                    enteredID = Integer.parseInt(input.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Find passenger with entered ID
                Passenger passenger = passengers.stream().filter(p -> p.getId() == enteredID).findFirst().orElse(null);
                if (passenger == null) {
                    JOptionPane.showMessageDialog(frame, "Passenger with ID " + enteredID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Display passenger information in the info panel
                    idLabel.setText("Passenger ID:                                    " + passenger.getId());
                    milesLabel.setText("Miles earned this year:                       " + passenger.getMiles());
                    tierLabel.setText("Tier:                                                " + passenger.getTier());
                    cancelledFlightsLabel.setText("Total number of cancelled flights: " + passenger.getCancelledFlights());
                    multiplierLabel.setText("Passenger has multiplier:                " + (passenger.hasMultiplier() ? "Yes" : "No"));
                }
            }
        });


        // Add ActionListener to "YES" and "NO" buttons for both questions
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              flightCancelled=true;
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flightCancelled=false;
            }
        });

        yes1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               passengerComplained=true;
            }
        });

        no1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               passengerComplained=false;
            }
        });


        // Add ActionListener to "ADD PASSENGER" button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve entered ID
                int enteredID;
                try {
                    enteredID = Integer.parseInt(ID.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Save the data to file
                saveDataToFile(enteredID, flightCancelled, passengerComplained);
            }
        });


        frame.add(headerPanel,BorderLayout.PAGE_START);
        frame.add(outerPanel1,BorderLayout.CENTER);
        frame.add(footer,BorderLayout.SOUTH);
        frame.setBounds(0,0,1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void saveDataToFile(int passengerID, boolean flightCancelled, boolean passengerComplained) {
        String fileName = "flightdata.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String data = "\n" + passengerID + " " + (flightCancelled ? "Y" : "N") + " " + (passengerComplained ? "Y" : "N");
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error occurred while saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

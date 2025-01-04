import Utility.CustomVariables;
import Utility.UtilityMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        createRailwayBooking();
    }
    public static void createRailwayBooking()  {
        CustomVariables.dbUrl="jdbc:mysql://localhost:3306/railwaydb";
        CustomVariables.username="root";
        CustomVariables.password="";
        //connection
        try {
            CustomVariables.conn = UtilityMethod.createConnection(CustomVariables.dbUrl , CustomVariables.username , CustomVariables.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //jframe
        JFrame frame = new JFrame("Railway Booking System");




//        //lables
        JLabel personalDlabel = new JLabel("Personal Details");
        personalDlabel.setBounds(10,10, 100,30);
        frame.add(personalDlabel);



        JLabel userNameLabel = new JLabel("Name: ");
        userNameLabel.setBounds(10 , 40, 100, 20);
        frame.add(userNameLabel);

        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(100 , 40, 100, 20);
        frame.add(usernameInput);

        JLabel selectGenderLabel = new JLabel("Select Gender");
        selectGenderLabel.setBounds(10 , 75, 100, 20);
        frame.add(selectGenderLabel);

        JRadioButton b1 = new JRadioButton("Male");
        b1.setBounds(100,70,60,30);
        JRadioButton b2 = new JRadioButton("Female");
        b2.setBounds(160,70,100,30);
        frame.add(b1);
        frame.add(b2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);

        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(10 , 110, 100, 20);
        frame.add(ageLabel);

        JTextField ageInput = new JTextField();
        ageInput.setBounds(100 , 110, 100, 20);
        frame.add(ageInput);

        JLabel mobileLabel = new JLabel("Mobile: ");
        mobileLabel.setBounds(10 , 150, 100, 20);
        frame.add(mobileLabel);

        JTextField mobileInput = new JTextField();
        mobileInput.setBounds(100 , 150, 100, 20);
        frame.add(mobileInput);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(10 , 190, 100, 20);
        frame.add(emailLabel);

        JTextField emailInput = new JTextField();
        emailInput.setBounds(100 , 190, 100, 20);
        frame.add(emailInput);

        JLabel ticketDetailLabel = new JLabel("Ticket Details");
        ticketDetailLabel.setBounds(300,10, 100,30);
        frame.add(ticketDetailLabel);

        JLabel dojLabel = new JLabel("Journey Date: ");
        dojLabel.setBounds(300 , 40, 100, 20);
        frame.add(dojLabel);

        JTextField dojInput = new JTextField();
        dojInput.setBounds(400 , 40, 100, 20);
        frame.add(dojInput);

        JLabel sourceLabel = new JLabel("Source: ");
        sourceLabel.setBounds(300 , 80, 100, 20);
        frame.add(sourceLabel);

        JTextField sourceInput = new JTextField();
        sourceInput.setBounds(400 , 80, 100, 20);
        frame.add(sourceInput);

        JLabel destinationLabel = new JLabel("Destination: ");
        destinationLabel.setBounds(300 , 120, 100, 20);
        frame.add(destinationLabel);

        JTextField destinationInput = new JTextField();
        destinationInput.setBounds(400 , 120, 100, 20);
        frame.add(destinationInput);

        JLabel priceLabel = new JLabel("Ticket Price: ");
        priceLabel.setBounds(300 , 160, 100, 20);
        frame.add(priceLabel);

        JTextField priceInput = new JTextField();
        priceInput.setBounds(400 , 160, 100, 20);
        frame.add(priceInput);

        JLabel preferenceLabel = new JLabel("Preference: ");
        preferenceLabel.setBounds(300 , 200, 100, 20);
        frame.add(preferenceLabel);

        String[] preferenceArray = {"Lower", "Upper", "Middle" , "Side Lower" , "Side Upper"};
        JComboBox<String> prefernceInput = new JComboBox<>(preferenceArray);
        prefernceInput.setBounds(400 , 200, 100, 20);
        frame.add(prefernceInput);

        JButton bookTicketBtn = new JButton("Book Ticket");
        bookTicketBtn.setBounds(100 , 260, 120, 20);
        frame.add(bookTicketBtn);

        JButton deleteTicketBtn = new JButton("Delete Bookings");
        deleteTicketBtn.setBounds(350 , 260, 150, 20);
        frame.add(deleteTicketBtn);

        JButton updateTicketBtn = new JButton("Update Ticket");
        updateTicketBtn.setBounds(400 , 300, 150, 20);
        frame.add(updateTicketBtn);
        updateTicketBtn.setVisible(false);

        JLabel bookingIDLabel = new JLabel("BookingID: ");
        bookingIDLabel.setBounds(10 , 300, 150, 20);
        frame.add(bookingIDLabel);

        JTextField bookingIDInput = new JTextField();
        bookingIDInput.setBounds(100 , 300, 50, 20);
        frame.add(bookingIDInput);

        JButton getDetailBtn = new JButton("Get Ticket");
        getDetailBtn.setBounds(200 , 300, 150, 20);
        frame.add(getDetailBtn);

        getDetailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookingID = Integer.parseInt(bookingIDInput.getText());
                    ResultSet resultSet = getBookingDetails(bookingID);

                    if (resultSet != null && resultSet.next()) {
                        usernameInput.setText(resultSet.getString("username"));
                        ageInput.setText(String.valueOf(resultSet.getInt("age")));
                        String gender = resultSet.getString("gender");
                        if ("Male".equals(gender)) {
                            b1.setSelected(true);
                        } else if ("Female".equals(gender)) {
                            b2.setSelected(true);
                        }
                        mobileInput.setText(resultSet.getString("mobile"));
                        emailInput.setText(resultSet.getString("email"));
                        dojInput.setText(resultSet.getString("doj"));
                        sourceInput.setText(resultSet.getString("source"));
                        destinationInput.setText(resultSet.getString("destination"));
                        priceInput.setText(resultSet.getString("ticketprice"));
                        prefernceInput.setSelectedItem(resultSet.getString("seat_preference"));
                        updateTicketBtn.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No booking found with ID: " + bookingID);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            }
        });

        deleteTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookingIDNumber = JOptionPane.showInputDialog("Enter Booking ID");
                String deleteMessage =  deleteTicket(Integer.parseInt(bookingIDNumber));
                JOptionPane.showMessageDialog(null, deleteMessage);
            }
        });

        bookTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genderData = b1.isSelected() ? b1.getText() : b2.getText();
                String bookticketOutput = bookTicket(usernameInput.getText(), Integer.parseInt(ageInput.getText()), genderData, mobileInput.getText(), emailInput.getText(), dojInput.getText(), sourceInput.getText(), destinationInput.getText(), priceInput.getText(), (String) prefernceInput.getSelectedItem());
                if (bookticketOutput.equals("Your ticket is booked")){
                   usernameInput.setText("");
                   ageInput.setText("");
                   b1.setSelected(false);
                   b2.setSelected(false);
                   mobileInput.setText("");
                   emailInput.setText("");
                   dojInput.setText("");
                   sourceInput.setText("");
                   destinationInput.setText("");
                   priceInput.setText("");
            }
                JOptionPane.showMessageDialog(null,bookticketOutput);
            }
        });

        updateTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genderData = b1.isSelected() ? b1.getText() : b2.getText();
                try {
                    int bookingID = Integer.parseInt(bookingIDInput.getText());
                    String bookticketOutput = updateTicket(bookingID, usernameInput.getText(), Integer.parseInt(ageInput.getText()), genderData, mobileInput.getText(), emailInput.getText(), dojInput.getText(), sourceInput.getText(), destinationInput.getText(), priceInput.getText(), (String) prefernceInput.getSelectedItem());
                    JOptionPane.showMessageDialog(null, bookticketOutput);
                    updateTicketBtn.setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input format");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                }
            }
        });


        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    private static String bookTicket(String username, int age, String gender, String mobile, String email, String DOJ, String sourceCity, String destination, String price, String preferenceType) {
        String insertQuery = "INSERT INTO ticketbookingtb (username, age, gender, mobile, email, doj, source, destination, ticketprice, seat_preference ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try (PreparedStatement statement = CustomVariables.conn.prepareStatement(insertQuery)) {
            statement.setString(1, username);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, mobile);
            statement.setString(5, email);
            statement.setString(6, DOJ);
            statement.setString(7, sourceCity);
            statement.setString(8, destination);
            statement.setString(9, price);
            statement.setString(10, preferenceType);
            statement.execute();
            return "Your ticket is booked";
        } catch (SQLException ex) {
            System.err.println("Booking failed: " + ex.getMessage());
            return "Booking failed: " + ex.getMessage();
        }
    }
    private static String updateTicket(int bookingID, String username, int age, String gender, String mobile, String email, String DOJ, String sourceCity, String destination, String price, String preferenceType) throws SQLException {
        String updateQuery = "UPDATE ticketbookingtb SET username = ?, age = ?, gender = ?, mobile = ?, email = ?, doj = ?, source = ?, destination = ?, ticketprice = ?, seat_preference = ? WHERE bookingID = ?";
        try (PreparedStatement statement = CustomVariables.conn.prepareStatement(updateQuery)) {
            statement.setString(1, username);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, mobile);
            statement.setString(5, email);
            statement.setString(6, DOJ);
            statement.setString(7, sourceCity);
            statement.setString(8, destination);
            statement.setString(9, price);
            statement.setString(10, preferenceType);
            statement.setInt(11, bookingID);

            statement.executeUpdate();
            return "Your ticket is updated";
        } catch (SQLException ex) {
            System.err.println("Update failed: " + ex.getMessage());
            return "Update failed: " + ex.getMessage();
        }
    }


    private static String deleteTicket(int bookingID) {
        String deleteQuery = "DELETE FROM ticketbookingtb WHERE bookingID = ?";
        try (PreparedStatement ps = CustomVariables.conn.prepareStatement(deleteQuery)) {
            ps.setInt(1, bookingID);
            ps.execute();
            System.out.println(ps);
            return "Booking Deleted";
        } catch (SQLException ex) {
            System.err.println("Deletion failed: " + ex.getMessage());
            return "Deletion failed: " + ex.getMessage();
        }
    }
    private static ResultSet getBookingDetails(int bookingID) {
        String selectQuery = "SELECT * FROM ticketbookingtb WHERE bookingID = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = CustomVariables.conn.prepareStatement(selectQuery);
            statement.setInt(1, bookingID);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Retrieval failed: " + ex.getMessage());
        }
        return resultSet;
     }

    }


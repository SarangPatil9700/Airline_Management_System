package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class Homepage extends JFrame implements ActionListener{
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
     public Homepage() {
        setLayout(null);

        // Adding the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        // Setting up the heading label
        JLabel heading = new JLabel("Welcome to Air India", SwingConstants.CENTER);
        heading.setBounds(0, 20, 1600, 60);  // Adjusted height for better appearance
        heading.setForeground(new Color(0, 102, 204)); // Attractive blue shade
        heading.setFont(new Font("Serif", Font.BOLD, 48)); // Larger and bolder font

        // Adding shadow effect (optional, using HTML for simplicity)
        heading.setText("<html><span style='color:#000000; text-shadow: 2px 2px #888888;'>Welcome to Air India</span></html>");
        image.add(heading);
        
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingpass = new JMenuItem("Boarding Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);
        

        // Set frame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    String text = ae.getActionCommand();

    if (text.equals("Add Customer Details")) {
        new AddCustomer();
    } else if (text.equals("Flight Details")) {
        new FlightInfo();
    } else if (text.equals("Book Flight")) {
        new BookFlight();
    } else if (text.equals("Journey Details")) {
        new JourneyDetails();
    } else if (text.equals("Cancel Ticket")) {
        new CancelTicket();
    } else if (text.equals("Boarding Pass")) { 
        new BoardingPass(); 
    }
}
    public static void main(String[] args)
    {
        new Homepage();
    }
}


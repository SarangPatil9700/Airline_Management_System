package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname,tfnationality, tfaddress, labelgender, labelfname, labelfcode, labeldate;
    JButton bookflight,fetchButton,flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight() {
    // Set background color to a soft gradient for a modern look
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    // Enhanced heading style for an attractive look
    // Enhanced heading style for an attractive look
        // Enhanced heading style for an attractive look
      JLabel heading = new JLabel("Book Flight");
      heading.setBounds(420, 20, 500, 35);
      heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
      heading.setForeground(Color.BLUE);
      this.add(heading);

       JLabel lblaadhar = new JLabel("Aadhar");
      lblaadhar.setBounds(60, 80, 150, 25);
      lblaadhar.setFont(new Font("Tahoma", 0, 16));
      add(lblaadhar);
      
    tfaadhar = new JTextField();
    tfaadhar.setBounds(220, 80, 150, 25); // Aadhar input field
    add(tfaadhar);
    
    fetchButton = new JButton("Fetch User");
    fetchButton.setBackground(Color.BLACK);
    fetchButton.setForeground(Color.WHITE);
    fetchButton.setBounds(380, 80, 120, 25); // Aadhar Fetch button
    fetchButton.addActionListener(this);
    add(fetchButton);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(60, 130, 150, 25); // Row 2: Name label
    lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblname);

    tfname = new JLabel();
    tfname.setBounds(220, 130, 150, 25); // Name field
    add(tfname);

    JLabel lblnationality = new JLabel("Nationality");
    lblnationality.setBounds(60, 180, 150, 25); // Row 3: Nationality label
    lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblnationality);

    tfnationality = new JLabel();
    tfnationality.setBounds(220, 180, 150, 25); // Nationality field
    add(tfnationality);

    JLabel lbladdress = new JLabel("Address");
    lbladdress.setBounds(60, 230, 150, 25); // Row 4: Address label
    lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lbladdress);

    tfaddress = new JLabel();
    tfaddress.setBounds(220, 230, 150, 25); // Address field
    add(tfaddress);

    JLabel lblgender = new JLabel("Gender");
    lblgender.setBounds(60, 280, 150, 25); // Row 5: Gender label
    lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblgender);

    labelgender = new JLabel();
    labelgender.setBounds(220, 280, 150, 25); // Gender field
    add(labelgender);

    JLabel lblsource = new JLabel("Source");
    lblsource.setBounds(60, 330, 150, 25); // Row 6: Source label
    lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblsource);
    
    source = new Choice();
    source.setBounds(220, 330, 150, 25);
    add(source);

    JLabel lbldest = new JLabel("Destination");
    lbldest.setBounds(60, 380, 150, 25); // Row 7: Destination label
    lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lbldest);
    
    destination = new Choice();
    destination.setBounds(220, 380, 150, 25);
    add(destination);
    
    
    try{
        Conn conn = new Conn();
        String query = "Select * from flight";
        conn.s.executeQuery(query);
        ResultSet rs = conn.s.executeQuery(query);
        
        while(rs.next()){
            source.add(rs.getString("source"));
            destination.add(rs.getString("destination"));
        }
        
        
    } catch(Exception e){
        e.printStackTrace();
    }
   

    flight = new JButton("Fetch Flights");
    flight.setBackground(Color.BLACK);
    flight.setForeground(Color.WHITE);
    flight.setBounds(380, 380, 120, 25); // Positioned below the labels
    flight.addActionListener(this);
    add(flight);
    
    JLabel lblfname = new JLabel("Flight Name");
    lblfname.setBounds(60, 430, 150, 25); // Row 4: Address label
    lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblfname);

    labelfname = new JLabel();
    labelfname.setBounds(220, 430, 150, 25); // Address field
    add(labelfname);
    
    JLabel lblfcode = new JLabel("Flight Code");
    lblfcode.setBounds(60, 480, 150, 25); // Row 4: Address label
    lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblfcode);

    labelfcode = new JLabel();
    labelfcode.setBounds(220, 480, 150, 25); // Address field
    add(labelfcode);
    
    JLabel lbldate = new JLabel("Date of Travel");
    lbldate.setBounds(60, 530, 150, 25); // Row 4: Address label
    lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lbldate);

    labeldate = new JLabel();
    labeldate.setBounds(220, 530, 150, 25); // Address field
    add(labeldate);
    
    dcdate = new JDateChooser();
    dcdate.setBounds(220, 530, 150, 25);
    add(dcdate);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
    Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
    ImageIcon image = new ImageIcon(i2);
    JLabel lblimage = new JLabel(image);
    lblimage.setBounds(550, 80, 500, 410);
    add(lblimage);
    
    bookflight = new JButton("Book Flight");
    bookflight.setBackground(Color.BLACK);
    bookflight.setForeground(Color.WHITE);
    bookflight.setBounds(220, 580, 150, 25); // Positioned below the labels
    bookflight.addActionListener(this);
    add(bookflight);
    
    
     // Adjusting window size, location, and making it visible
            setSize(1100, 700);
            setLocation(200, 50);
            setVisible(true);              

           
}
    
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchButton){
        String aadhar = tfaadhar.getText();
        
        try{
            Conn conn = new Conn();

            String query = "select * from passenger where aadhar = '"+aadhar+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
            }else{
                JOptionPane.showMessageDialog(null, "Please enter valid aadhar");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
}else{
            if(ae.getSource() == flight){
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        
        try{
            Conn conn = new Conn();

            String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
            }else{
                JOptionPane.showMessageDialog(null, "No flights available for the selected route or date.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }else{
                Random random = new Random();
                String aadhar = tfaadhar.getText();
                String name = tfname.getText();
                String nationality = tfnationality.getText();
                String flightname = labelfname.getText();
                String flightcode = labelfcode.getText();
                String src = source.getSelectedItem();
                String des = destination.getSelectedItem();
                String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();   
                
                try{
            Conn conn = new Conn();

            String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"' ,'"+name+"', '"+nationality+"' ,'"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";
            
            conn.s.executeUpdate(query);
            
            
            JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   }        
}
    public static void main(String[] args){
        new BookFlight(); // Opens the BookFlight frame
    }
}


package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname,tfnationality, lblsrc , lbldest, lblfname, lblfcode, lbldate;
    JButton fetchButton;
    
    public BoardingPass() {
    // Set background color to a soft gradient for a modern look
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    // Enhanced heading style for an attractive look
    // Enhanced heading style for an attractive look
        // Enhanced heading style for an attractive look
      JLabel heading = new JLabel("AIR INDIA");
      heading.setBounds(380, 10, 450, 35);
      heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
      this.add(heading);
      
      JLabel subheading = new JLabel("Boarding Pass");
      subheading.setBounds(360, 50, 300, 30);
      subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
      subheading.setForeground(Color.BLUE);
      this.add(subheading);


      JLabel lblaadhar = new JLabel("PNR DETAILS");
      lblaadhar.setBounds(60, 100, 150, 25);
      lblaadhar.setFont(new Font("Tahoma", 0, 16));
      add(lblaadhar);
      
    tfpnr = new JTextField();
    tfpnr.setBounds(220, 100, 150, 25); // Aadhar input field
    add(tfpnr);
    
    fetchButton = new JButton("Enter");
    fetchButton.setBackground(Color.BLACK);
    fetchButton.setForeground(Color.WHITE);
    fetchButton.setBounds(380, 100, 120, 25); // Aadhar Fetch button
    fetchButton.addActionListener(this);
    add(fetchButton);

    JLabel labelname = new JLabel("NAME");
    labelname.setBounds(60, 140, 150, 25); // Row 2: Name label
    labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labelname);

    tfname = new JLabel();
    tfname.setBounds(220, 140, 150, 25); // Name field
    add(tfname);

    JLabel lblnationality = new JLabel("NATIONALITY");
    lblnationality.setBounds(60, 180, 150, 25); // Row 3: Nationality label
    lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(lblnationality);

    tfnationality = new JLabel();
    tfnationality.setBounds(220, 180, 150, 25); // Nationality field
    add(tfnationality);

    JLabel labelsource = new JLabel("SRC");
    labelsource .setBounds(60, 220, 150, 25); // Row 4: Source label
    labelsource .setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labelsource );

    lblsrc = new JLabel();
    lblsrc .setBounds(220, 220, 150, 25); // Source field
    add(lblsrc );

    JLabel labeldest = new JLabel("DEST");
    labeldest.setBounds(380, 220, 150, 25); // Row 5: Destination label
    labeldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labeldest);

    lbldest = new JLabel();
    lbldest.setBounds(540, 220, 150, 25); // Destination field
    add(lbldest);

    JLabel labelfname = new JLabel("Flight Name");
    labelfname.setBounds(60, 260, 150, 25); // Row 4: FlightName label
    labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labelfname);

    lblfname = new JLabel();
    lblfname.setBounds(220, 260, 150, 25); // FlightName field
    add(lblfname);
    
    JLabel labelfcode = new JLabel("Flight Code");
    labelfcode.setBounds(380, 260, 150, 25); // Row 4: FlightCode label
    labelfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labelfcode);

    lblfcode = new JLabel();
    lblfcode.setBounds(540, 260, 150, 25); // FlightCode field
    add(lblfcode);
    
    JLabel labeldate = new JLabel("Date");
    labeldate.setBounds(60, 300, 150, 25); // Row 4: Date label
    labeldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(labeldate);

    lbldate = new JLabel();
    lbldate.setBounds(220, 300, 150, 25); // Date field
    add(lbldate);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
    Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
    ImageIcon image = new ImageIcon(i2);
    JLabel lblimage = new JLabel(image);
    lblimage.setBounds(600, 0, 300, 300);
    add(lblimage);
    
    
     // Adjusting window size, location, and making it visible
            setSize(1000, 450);
            setLocation(300, 150);
            setVisible(true);              

    }
        public void actionPerformed(ActionEvent ae){
        String pnr = tfpnr.getText();

        try{
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
           if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality")) ;
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                lblfname.setText(rs.getString("flightname"));
                lblfcode.setText(rs.getString("flightcode"));
                lbldate.setText(rs.getString("ddate"));          
            }else{
                JOptionPane.showMessageDialog(null, "Please enter valid PNR");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new BoardingPass(); // Opens the Boarding Pass frame
    }
}
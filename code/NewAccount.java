
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class NewAccount extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JButton b1;
    JTextField t1,t2,t3,t4;
    NewAccount(){
        super("New Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,780);
        setVisible(true);
        setComponents();
    }
    void setComponents(){
        l1 = new JLabel("First Name: ",JLabel.CENTER);
        l2 = new JLabel("Last Name: ",JLabel.CENTER);
        l3 = new JLabel("Username: ",JLabel.CENTER);
        l4 = new JLabel("Password: ",JLabel.CENTER);
        l5 = new JLabel();

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        b1 = new JButton("Submit");

        b1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l2.setFont(new Font("Verdana", Font.PLAIN, 20));
        l3.setFont(new Font("Verdana", Font.PLAIN, 20));
        l4.setFont(new Font("Verdana", Font.PLAIN, 20));
        l5.setFont(new Font("Verdana", Font.PLAIN, 20));
        t1.setFont(new Font("Verdana", Font.PLAIN, 20));
        t2.setFont(new Font("Verdana", Font.PLAIN, 20));
        t3.setFont(new Font("Verdana", Font.PLAIN, 20));
        t3.setFont(new Font("Verdana", Font.PLAIN, 20));


        l1.setBounds(300,200,200,30);
        l2.setBounds(300,250,200,30);
        l3.setBounds(300,300,200,30);
        l5.setBounds(700,300,400,30);
        l4.setBounds(300,350,200,30);
        t1.setBounds(550,200,200,30);
        t2.setBounds(550,250,200,30);
        t3.setBounds(550,300,200,30);
        t4.setBounds(550,350,200,30);
        b1.setBounds(400,400,150,50);

        b1.addActionListener(this);

        setLayout(null);
        add(l1);add(l2);add(l3);add(l4);add(t1);add(t2);add(t3);add(t4);add(b1);add(l5);

    }
    public void actionPerformed(ActionEvent e) {
        String fname = t1.getText();
        String lname = t2.getText();
        Login.user = t3.getText();
        String pass = t4.getText();
        Random random = new Random(System.nanoTime());
        int randomInt = random.nextInt(1000000000);
        String id = "A" + randomInt;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sarosh@786");
            String query = "insert into accounttable(FirstName,custId,LastName,password,username,balance) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, pass);
            preparedStatement.setString(5, Login.user);
            preparedStatement.setFloat(6, Login.balance);
            dispose();
            new Cash();
            preparedStatement.execute();
            connection.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }
}

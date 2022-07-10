
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JButton b1;
    JTextField t1,t2;
    static public String user, pass;
    static public float balance;
    public Login() {
        super("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,780);
        setVisible(true);
        setComponents();
    }
    void setComponents(){
        l1 = new JLabel("Username: ",JLabel.CENTER);
        l2 = new JLabel("Password: ",JLabel.CENTER);
        l3 = new JLabel("Wrong Password. Please try again...");
        l4 = new JLabel("Username is Wrong");

        t1 = new JTextField();
        t2 = new JTextField();
        b1 = new JButton("Submit");

        l3.setFont(new Font("Verdana", Font.ITALIC, 20));
        l4.setFont(new Font("Verdana", Font.ITALIC, 20));
        b1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l1.setFont(new Font("Verdana", Font.PLAIN, 20));
        l2.setFont(new Font("Verdana", Font.PLAIN, 20));
        t1.setFont(new Font("Verdana", Font.PLAIN, 20));
        t2.setFont(new Font("Verdana", Font.PLAIN, 20));

        l3.setBounds(800,300,200,30);
        l4.setBounds(800,250,200,30);
        l1.setBounds(300,250,200,30);
        l2.setBounds(300,300,200,30);
        t1.setBounds(550,250,200,30);
        t2.setBounds(550,300,200,30);
        b1.setBounds(400,400,150,50);

        l3.setVisible(false);
        l4.setVisible(false);
        b1.addActionListener(this);

        setLayout(null);
        add(l1);add(l2);add(l3);add(l4);add(t1);add(t2);add(b1);
    }
    public void actionPerformed(ActionEvent e){
        user = t1.getText();
        pass = t2.getText();
        String u = "";
        String p = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sarosh@786");
            Statement stat = connection.createStatement();
            String query = "Select * from accounttable Where username='" + user + "'";
            ResultSet resultSet = stat.executeQuery(query);
            while (resultSet.next()){
                u = resultSet.getString("username");
                p = resultSet.getString("password");
                balance = resultSet.getFloat("balance");
            }
            if (!user.isEmpty() && user.equals(u)) {
                l4.setVisible(false);
                if (!pass.isEmpty() && pass.equals(p)) {
                    System.out.println("Proceed");
                    l3.setVisible(false);
                    dispose();
                    new Cash();
                } else {
                    l3.setVisible(true);
                }
            } else {
                l4.setVisible(true);
            }

            stat.close();
            connection.close();
        }
        catch (Exception a){
            a.printStackTrace();
        }
    }

}
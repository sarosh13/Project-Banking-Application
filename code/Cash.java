import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Cash extends JFrame implements ActionListener{
    JLabel l1,l2;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bd,bw,bb,bp;
    String s="";
    public Cash() {
        super("ATM");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,780);
        setVisible(true);
        setComponents();
    }
    void setComponents(){
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bd = new JButton("D");
        bw = new JButton("W");
        bb = new JButton("B");
        bp = new JButton("Exit");
        l1 = new JLabel(" Enter an amount");
        l2 = new JLabel(" Display Screen");


        l1.setOpaque(true);
        l2.setOpaque(true);
        l1.setBackground(Color.black);
        l1.setForeground(Color.white);
        l2.setBackground(Color.black);
        l2.setForeground(Color.white);

        l1.setFont(new Font("Verdana", Font.PLAIN, 30));
        l2.setFont(new Font("Verdana", Font.PLAIN, 30));

        b1.setFont(new Font("Verdana", Font.PLAIN, 40));
        b2.setFont(new Font("Verdana", Font.PLAIN, 40));
        b3.setFont(new Font("Verdana", Font.PLAIN, 40));
        b4.setFont(new Font("Verdana", Font.PLAIN, 40));
        b5.setFont(new Font("Verdana", Font.PLAIN, 40));
        b6.setFont(new Font("Verdana", Font.PLAIN, 40));
        b7.setFont(new Font("Verdana", Font.PLAIN, 40));
        b8.setFont(new Font("Verdana", Font.PLAIN, 40));
        b9.setFont(new Font("Verdana", Font.PLAIN, 40));
        b0.setFont(new Font("Verdana", Font.PLAIN, 40));

        bd.setFont(new Font("Verdana", Font.PLAIN, 40));
        bp.setFont(new Font("Verdana", Font.PLAIN, 40));
        bb.setFont(new Font("Verdana", Font.PLAIN, 40));
        bw.setFont(new Font("Verdana", Font.PLAIN, 40));

        l1.setBounds(100,50,1000,70);
        l2.setBounds(600,440,500,220);
        b1.setBounds(100,200,100,100);
        b2.setBounds(220,200,100,100);
        b3.setBounds(340,200,100,100);
        b4.setBounds(100,320,100,100);
        b5.setBounds(220,320,100,100);
        b6.setBounds(340,320,100,100);
        b7.setBounds(100,440,100,100);
        b8.setBounds(220,440,100,100);
        b9.setBounds(340,440,100,100);
        b0.setBounds(220,560,100,100);
        bd.setBounds(460,200,100,100);
        bw.setBounds(460,320,100,100);
        bb.setBounds(460,440,100,100);
        bp.setBounds(460,560,100,100);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bd.addActionListener(this);
        bb.addActionListener(this);
        bp.addActionListener(this);
        bw.addActionListener(this);

        setLayout(null);
        add(b0);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(bb);add(bw);add(bp);add(bd);add(l1);add(l2);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b1){
            s = s+b1.getText();
            l1.setText(s);
        }
        if (e.getSource()==b2){
            s = s+b2.getText();
            l1.setText(s);
        }
        if (e.getSource()==b3){
            s = s+b3.getText();
            l1.setText(s);
        }
        if (e.getSource()==b4){
            s = s+b4.getText();
            l1.setText(s);
        }
        if (e.getSource()==b5){
            s = s+b5.getText();
            l1.setText(s);
        }
        if (e.getSource()==b6){
            s = s+b6.getText();
            l1.setText(s);
        }
        if (e.getSource()==b7){
            s = s+b7.getText();
            l1.setText(s);
        }
        if (e.getSource()==b8){
            s = s+b8.getText();
            l1.setText(s);
        }
        if (e.getSource()==b9){
            s = s+b9.getText();
            l1.setText(s);
        }
        if (e.getSource()==b0){
            s = s+b0.getText();
            l1.setText(s);
        }

        if (s!=""){
            if (e.getSource()==bd) {
                l2.setText("Deposited: Rs. " + s);
                l1.setText("");
                Login.balance = Login.balance + Float.valueOf(s);
                System.out.println(Float.valueOf(s));
                System.out.println(Login.balance);
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Sarosh@786");
                    String query = String.format("update accounttable set balance=%f where username='%s'",Login.balance,Login.user);
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.execute();
                    connection.close();
                } catch (Exception ie){
                    ie.printStackTrace();
                }
                s = "";
            }
            if (e.getSource()==bw && Login.balance>0 && Float.valueOf(s)<Login.balance){
                l2.setText("Money Withdrawal: Rs. "+s);
                l1.setText("");
                Login.balance = Math.abs(Login.balance - Float.valueOf(s));
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Sarosh@786");
                    String query = String.format("update accounttable set balance=%f where username='%s'",Login.balance,Login.user);
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.execute();
                    connection.close();
                } catch (Exception ie){
                    ie.printStackTrace();
                }
                s = "";
            }
            if (Login.balance==0 && Float.valueOf(s)>Login.balance)
                l2.setText("Not enough balance");

        }
        if (e.getSource() == bb) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Sarosh@786");
                String query = String.format("select balance from accounttable where username='%s'",Login.user);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeQuery();
                connection.close();

            } catch (Exception ie){
                ie.printStackTrace();
            }
            l2.setText(String.valueOf(Login.balance));
        }

        if (e.getSource() == bp) {
                dispose();
                new EndFrame();
        }
    }
}

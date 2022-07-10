import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener{
    JButton b1,b2;

    public FirstFrame(String s) {
        super(s);
    }
    public void setComponents() {
        b1 = new JButton("Log In");
        b2 = new JButton("Create New Account");
        b1.setFont(new Font("Verdana", Font.PLAIN, 20));
        b2.setFont(new Font("Verdana", Font.PLAIN, 20));
        b1.setBounds(500,200,300,50);
        b2.setBounds(500,300,300,50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(null);
        add(b1);
        add(b2);
    }
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getSource()==b1){
            new Login();
        }
        else
            new NewAccount();
    }

    public static void main(String[] args) {
        FirstFrame jf = new FirstFrame("Punjab National Bank");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1280,780);
        jf.setVisible(true);
        jf.setComponents();
    }
}

import javax.swing.*;
import java.awt.*;

public class EndFrame extends JFrame {
    JLabel l1,l2;
    public EndFrame(){
        super("Exit");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200,780);
        setVisible(true);
        setComponents();
    }
    void setComponents(){
        l1 = new JLabel("Thank you for using PNB Bank.");
        l2 = new JLabel("Please Come Again");

        l1.setFont(new Font("Verdana", Font.PLAIN, 50));
        l2.setFont(new Font("Verdana", Font.PLAIN, 50));

        l1.setBounds(300,300,1000,70);
        l2.setBounds(400,400,700,70);

        setLayout(null);
        add(l1);add(l2);
    }
}

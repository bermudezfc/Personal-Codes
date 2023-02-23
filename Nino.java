
package GUI;
import java.awt.*;
import javax.swing.*;

public class Nino {
    JFrame frame = new JFrame();
    ImageIcon bg = new ImageIcon("nino.jfif");
    JButton btn = new JButton("Tite");
    

    
    
    public Nino(){
        Image img = bg.getImage();
        bg = new ImageIcon(img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH));
        
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        JLabel lblBack = new JLabel(bg);
        lblBack.setLayout(new FlowLayout());
        lblBack.setBounds(0, 0, 1920, 1080);
        
        btn.setBounds(100, 100, 100, 100);
        lblBack.add(btn);
        
        
        
        
        frame.add(lblBack);
        
        
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Nino GUI = new Nino();
        
        
        
    }
}

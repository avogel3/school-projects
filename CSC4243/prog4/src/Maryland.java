import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Created by Zackery on 4/25/2016.
 */
public class Maryland extends JFrame{
    private JPanel mdFrame;
    private JButton _lastButtonPressed;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Maryland frame = new Maryland();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public Maryland() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1024, 768);
        mdFrame = new JPanel();
        mdFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mdFrame);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(40, -262, 800, 768);
        Image img = new ImageIcon(this.getClass().getResource("/images/water.png")).getImage();
        Image img2 = new ImageIcon(this.getClass().getResource("/images/md_2.png")).getImage().getScaledInstance(500, 294, Image.SCALE_DEFAULT);
        Image img3 = new ImageIcon(this.getClass().getResource("/images/menu_bar.png")).getImage();
        Image img4 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();
        Image img5 = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage();
        Image img6 = new ImageIcon(this.getClass().getResource("/images/facts.png")).getImage();
        Image img7 = new ImageIcon(this.getClass().getResource("/images/md.png")).getImage();
        mdFrame.setLayout(null);

        final JButton intro = new JButton("");
        intro.setBounds(385, 85, 162, 46);
        intro.setIcon(new ImageIcon(img4));
        intro.addActionListener(actionEvent -> {
            dispose();
            Frame1 frame1 = new Frame1();
            frame1.setVisible(true);
        });
        intro.setBorderPainted(false);
        intro.setFocusPainted(false);
        intro.setContentAreaFilled(false);
        mdFrame.setLayout(null);
        mdFrame.add(intro);

        final JButton rand = new JButton("");
        rand.setBounds(620, 84, 97, 46);
        rand.setIcon(new ImageIcon(img5));
        rand.addActionListener(actionEvent -> {
            dispose();
            Louisiana frame1 = new Louisiana();
            California frame2 = new California();
            Maryland frame3 = new Maryland();
            Michigan frame4 = new Michigan();
            frame2.setVisible(true);
        });
        rand.setBorderPainted(false);
        rand.setFocusPainted(false);
        rand.setContentAreaFilled(false);
        mdFrame.setLayout(null);
        mdFrame.add(rand);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(350, -90, 800, 400);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        mdFrame.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        //lblNewLabel_1.setBounds(120, 295, 450, 350);
        lblNewLabel_1.setLocation(40, 300);
        lblNewLabel_1.setSize(500, 294);

        lblNewLabel_1.setIcon(new ImageIcon(img2));
        mdFrame.add(lblNewLabel_1);

        final JLabel mdFacts = new JLabel("<html> The largest body of water in <br> Maryland is the Chesapeake Bay, but <br> it also has nearly 50 rivers <br> and creeks, plus streams,<br> lakes, ponds and the Atlantic Ocean. </html>");
        mdFacts.setBounds(550, 340,700, 250);
        mdFacts.setForeground(new Color(53, 122, 127));
        mdFacts.setFont(new Font("Calibri", Font.PLAIN, 30));
        mdFacts.setVisible(false);
        mdFrame.add(mdFacts);

        final JButton facts = new JButton("");
        facts.setBounds(720, 290, 153, 52);
        facts.setIcon(new ImageIcon(img6));
        facts.addActionListener(actionEvent -> {
            JButton buttonPressed = (JButton) actionEvent.getSource();
            if (_lastButtonPressed == buttonPressed)
            {
                mdFrame.remove(mdFacts);
                mdFrame.revalidate();
                mdFrame.repaint();
            }
            mdFacts.setVisible(true);
            _lastButtonPressed = buttonPressed;
        });
        mdFrame.setLayout(null);
        mdFrame.add(facts);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(465, 190, 166, 103);
        lblNewLabel_6.setIcon(new ImageIcon(img7));
        mdFrame.add(lblNewLabel_6);
        lblNewLabel.setIcon(new ImageIcon(img));
        mdFrame.add(lblNewLabel);
    }
}

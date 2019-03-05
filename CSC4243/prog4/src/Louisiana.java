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
public class Louisiana extends JFrame{
    private JPanel laFrame;
    private JButton _lastButtonPressed;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Louisiana frame = new Louisiana();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public Louisiana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        laFrame = new JPanel();
        laFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(laFrame);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(40, -262, 800, 768);
        Image img = new ImageIcon(this.getClass().getResource("/images/water.png")).getImage();
        Image img2 = new ImageIcon(this.getClass().getResource("/images/la_2.png")).getImage().getScaledInstance(500, 452, Image.SCALE_DEFAULT);
        Image img3 = new ImageIcon(this.getClass().getResource("/images/menu_bar.png")).getImage();
        Image img4 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();
        Image img5 = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage();
        Image img6 = new ImageIcon(this.getClass().getResource("/images/facts.png")).getImage();
        Image img7 = new ImageIcon(this.getClass().getResource("/images/la.png")).getImage();
        laFrame.setLayout(null);

        final JButton intro = new JButton("");
        intro.setBounds(385, 85, 165, 58);
        intro.setIcon(new ImageIcon(img4));
        intro.addActionListener(actionEvent -> intro.setVisible(true));
        intro.setBorderPainted(false);
        intro.setFocusPainted(false);
        intro.setContentAreaFilled(false);
        laFrame.setLayout(null);
        laFrame.add(intro);

        JButton rand = new JButton("");
        rand.setBounds(620, 90, 96, 45);
        rand.setIcon(new ImageIcon(img5));
        rand.addActionListener(actionEvent -> {
            dispose();
            Louisiana frame1 = new Louisiana();
            California frame2 = new California();
            Maryland frame3 = new Maryland();
            Michigan frame4 = new Michigan();
            frame4.setVisible(true);
        });
        rand.setBorderPainted(false);
        rand.setFocusPainted(false);
        rand.setContentAreaFilled(false);
        laFrame.setLayout(null);
        laFrame.add(rand);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(350, -90, 800, 400);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        laFrame.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        //lblNewLabel_1.setBounds(100, 280, 450, 370);
        lblNewLabel_1.setLocation(40, 300);
        lblNewLabel_1.setSize(500, 452);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        laFrame.add(lblNewLabel_1);

        final JLabel laFacts = new JLabel("<html> Louisiana is blessed <br> with an abundance <br> of high quality ground water.  </html>");
        laFacts.setBounds(550, 372,700, 150);
        laFacts.setForeground(new Color(53, 122, 127));
        laFacts.setFont(new Font("Calibri", Font.PLAIN, 30));
        laFacts.setVisible(false);
        laFrame.add(laFacts);

        final JLabel laFacts2 = new JLabel("<html> In fact, ground water is the primary <br> source of drinking water for 61 <br> percent of Louisiana's residents. </html>");
        laFacts2.setBounds(550, 372,700, 150);
        laFacts2.setForeground(new Color(53, 122, 127));
        laFacts2.setFont(new Font("Calibri", Font.PLAIN, 30));
        laFacts2.setVisible(false);
        laFrame.add(laFacts2);

        JButton facts = new JButton("");
        facts.setBounds(720, 290, 153, 52);
        facts.setIcon(new ImageIcon(img6));
        facts.addActionListener(actionEvent -> {
            JButton buttonPressed = (JButton) actionEvent.getSource();
            if (_lastButtonPressed == buttonPressed)
            {
                laFrame.remove(laFacts);
                laFrame.revalidate();
                laFrame.repaint();
                laFacts2.setVisible(true);
            }
            laFacts.setVisible(true);
            _lastButtonPressed = buttonPressed;
        });
        laFrame.setLayout(null);
        laFrame.add(facts);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(465, 190, 166, 103);
        lblNewLabel_6.setIcon(new ImageIcon(img7));
        laFrame.add(lblNewLabel_6);
        lblNewLabel.setIcon(new ImageIcon(img));
        laFrame.add(lblNewLabel);
    }
}

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Created by Zackery on 4/25/2016.
 */
public class Florida extends JFrame{
    private JPanel flFrame;
    private JButton _lastButtonPressed;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Florida frame = new Florida();
                frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            });
        }
    public Florida() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1024, 768);
        flFrame = new JPanel();
        flFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(flFrame);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(40, -262, 800, 768);
        Image img = new ImageIcon(this.getClass().getResource("/images/water.png")).getImage();
        Image img2 = new ImageIcon(this.getClass().getResource("/images/fl_2.png")).getImage().getScaledInstance(500, 366, Image.SCALE_DEFAULT);
        Image img3 = new ImageIcon(this.getClass().getResource("/images/menu_bar.png")).getImage();
        Image img4 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();
        Image img5 = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage();
        Image img6 = new ImageIcon(this.getClass().getResource("/images/facts.png")).getImage();
        Image img7 = new ImageIcon(this.getClass().getResource("/images/fl.png")).getImage();
        flFrame.setLayout(null);

        final JButton intro = new JButton("");
        intro.setBounds(385, 85, 162, 46);
        intro.setIcon(new ImageIcon(img4));
        intro.addActionListener(actionEvent -> {
            dispose();
            //SimpleSwingBrowser frame1 = new SimpleSwingBrowser();
            Frame1 frame1 = new Frame1();
            frame1.setVisible(true);
        });
        intro.setBorderPainted(false);
        intro.setFocusPainted(false);
        intro.setContentAreaFilled(false);
        flFrame.setLayout(null);
        flFrame.add(intro);

        final JButton rand = new JButton("");
        rand.setBounds(620, 85, 97, 46);
        rand.setIcon(new ImageIcon(img5));
        rand.addActionListener(actionEvent -> {
            dispose();
            Louisiana frame1 = new Louisiana();
            California frame2 = new California();
            Maryland frame3 = new Maryland();
            Michigan frame4 = new Michigan();
            frame1.setVisible(true);
        });
        rand.setBorderPainted(false);
        rand.setFocusPainted(false);
        rand.setContentAreaFilled(false);
        flFrame.setLayout(null);
        flFrame.add(rand);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(350, -90, 800, 400);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        flFrame.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setLocation(40, 300);
        lblNewLabel_1.setSize(500, 366);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        flFrame.add(lblNewLabel_1);

        final JLabel floFacts = new JLabel("<html> Nearly 90 percent of the 16 million <br> residents  of Florida obtained <br> their drinking water <br> from public supply water systems. </html>");
        floFacts.setBounds(550, 390,700, 150);
        floFacts.setForeground(new Color(53, 122, 127));
        floFacts.setFont(new Font("Calibri", Font.PLAIN, 30));
        floFacts.setVisible(false);
        flFrame.add(floFacts);

        final JLabel floFacts2 = new JLabel("<html> Florida has more than <br> 11,000 miles of rivers, streams <br> & waterways. </html>");
        floFacts2.setBounds(550, 371,700, 150);
        floFacts2.setForeground(new Color(53, 122, 127));
        floFacts2.setFont(new Font("Calibri", Font.PLAIN, 30));
        floFacts2.setVisible(false);
        flFrame.add(floFacts2);

        JButton facts = new JButton("");
        facts.setBounds(720, 290, 153, 52);
        facts.setIcon(new ImageIcon(img6));
        facts.addActionListener(actionEvent -> {
            JButton buttonPressed = (JButton) actionEvent.getSource();
            if (_lastButtonPressed == buttonPressed)
            {
                flFrame.remove(floFacts);
                flFrame.revalidate();
                flFrame.repaint();
                floFacts2.setVisible(true);
            }
            floFacts.setVisible(true);
            _lastButtonPressed = buttonPressed;
        });
        flFrame.setLayout(null);
        flFrame.add(facts);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(465, 190, 166, 103);
        lblNewLabel_6.setIcon(new ImageIcon(img7));
        flFrame.add(lblNewLabel_6);
        lblNewLabel.setIcon(new ImageIcon(img));
        flFrame.add(lblNewLabel);
    }
}

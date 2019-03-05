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
public class Michigan extends JFrame{
    private JPanel miFrame;
    private JButton _lastButtonPressed;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Michigan frame = new Michigan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Michigan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        miFrame = new JPanel();
        miFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(miFrame);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(40, -262, 800, 768);
        Image img = new ImageIcon(this.getClass().getResource("/images/water.png")).getImage();
        Image img2 = new ImageIcon(this.getClass().getResource("/images/mi_2.png")).getImage().getScaledInstance(500, 472, Image.SCALE_DEFAULT);
        Image img3 = new ImageIcon(this.getClass().getResource("/images/menu_bar.png")).getImage();
        Image img4 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();
        Image img5 = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage();
        Image img6 = new ImageIcon(this.getClass().getResource("/images/facts.png")).getImage();
        Image img7 = new ImageIcon(this.getClass().getResource("/images/mi.png")).getImage();
        miFrame.setLayout(null);

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
        miFrame.setLayout(null);
        miFrame.add(intro);

        final JButton rand = new JButton("");
        rand.setBounds(620, 84, 97, 46);
        rand.setIcon(new ImageIcon(img5));
        rand.addActionListener(actionEvent -> {
            dispose();
            Louisiana frame1 = new Louisiana();
            California frame2 = new California();
            Maryland frame3 = new Maryland();
            Michigan frame4 = new Michigan();
            Florida frame5 = new Florida();
            frame3.setVisible(true);
        });
        rand.setBorderPainted(false);
        rand.setFocusPainted(false);
        rand.setContentAreaFilled(false);
        miFrame.setLayout(null);
        miFrame.add(rand);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(350, -90, 800, 400);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        miFrame.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        //lblNewLabel_1.setBounds(90, 318, 450, 350);
        lblNewLabel_1.setLocation(40, 250);
        lblNewLabel_1.setSize(500, 472);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        miFrame.add(lblNewLabel_1);

        final JLabel miFacts = new JLabel("<html> There are about 120 major <br> rivers in Michigan. The total miles <br> that these rivers cover is <br> about 36,350 square miles. </html>");
        miFacts.setBounds(550, 390,700, 150);
        miFacts.setForeground(new Color(53, 122, 127));
        miFacts.setFont(new Font("Calibri", Font.PLAIN, 30));
        miFacts.setVisible(false);
        miFrame.add(miFacts);

        final JLabel miFacts2 = new JLabel("<html> The Great Lakes contain 20% <br> of the fresh water supply for <br> the entire world. </html>");
        miFacts2.setBounds(550, 371,700, 150);
        miFacts2.setForeground(new Color(53, 122, 127));
        miFacts2.setFont(new Font("Calibri", Font.PLAIN, 30));
        miFacts2.setVisible(false);
        miFrame.add(miFacts2);

        final JButton facts = new JButton("");
        facts.setBounds(720, 290, 153, 52);
        facts.setIcon(new ImageIcon(img6));
        facts.addActionListener(actionEvent -> {
            JButton buttonPressed = (JButton) actionEvent.getSource();
            if (_lastButtonPressed == buttonPressed)
            {
                miFrame.remove(miFacts);
                miFrame.revalidate();
                miFrame.repaint();
                miFacts2.setVisible(true);
            }
            miFacts.setVisible(true);
            _lastButtonPressed = buttonPressed;
        });
        miFrame.setLayout(null);
        miFrame.add(facts);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setBounds(465, 190, 166, 103);
        lblNewLabel_6.setIcon(new ImageIcon(img7));
        miFrame.add(lblNewLabel_6);
        lblNewLabel.setIcon(new ImageIcon(img));
        miFrame.add(lblNewLabel);
    }
}

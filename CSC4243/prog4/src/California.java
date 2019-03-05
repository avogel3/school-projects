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
public class California extends JFrame{
	private JPanel caFrame;
	private JButton _lastButtonPressed;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                California frame = new California();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}
	public California() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(1024, 768);
		caFrame = new JPanel();
		caFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(caFrame);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(40, -262, 800, 768);
		Image img = new ImageIcon(this.getClass().getResource("/images/water.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/images/cali_2.png")).getImage().getScaledInstance(400, 603, Image.SCALE_DEFAULT);
		Image img3 = new ImageIcon(this.getClass().getResource("/images/menu_bar.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();
		Image img5 = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage();
		Image img6 = new ImageIcon(this.getClass().getResource("/images/facts.png")).getImage();
		Image img7 = new ImageIcon(this.getClass().getResource("/images/ca.png")).getImage();
		caFrame.setLayout(null);

		final JButton intro = new JButton("");
		intro.setBounds(385, 85, 153, 44);
		intro.setIcon(new ImageIcon(img4));
		intro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				dispose();
				Frame1 frame1 = new Frame1();
				frame1.setVisible(true);
			}
		});
		intro.setBorderPainted(false);
		intro.setFocusPainted(false);
		intro.setContentAreaFilled(false);
		caFrame.setLayout(null);
		caFrame.add(intro);

		final JButton rand = new JButton("");
		rand.setBounds(620, 84, 97, 46);
		rand.setIcon(new ImageIcon(img5));
		rand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
				Louisiana frame1 = new Louisiana();
				California frame2 = new California();
				Maryland frame3 = new Maryland();
				Michigan frame4 = new Michigan();
				Florida frame5 = new Florida();
				frame5.setVisible(true);
			}
		});
		rand.setBorderPainted(false);
		rand.setFocusPainted(false);
		rand.setContentAreaFilled(false);
		caFrame.setLayout(null);
		caFrame.add(rand);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(350, -90, 800, 400);
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		caFrame.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setLocation(58, 156);
		lblNewLabel_1.setSize(400, 633);
		caFrame.add(lblNewLabel_1);

		final  JLabel caFacts = new JLabel("<html> More than 44 percent of California <br> is in exceptional<br>  drought the worst <br> level of drought.</html>");
		caFacts.setBounds(550, 390,700, 150);
		caFacts.setForeground(new Color(53, 122, 127));
		caFacts.setFont(new Font("Calibri", Font.PLAIN, 30));
		caFacts.setVisible(false);
		caFrame.add(caFacts);

		final JLabel caFacts2 = new JLabel("<html> Nearly 60 percent of<br> the states water needs are <br> now met by groundwater. </html>");
		caFacts2.setBounds(550, 371,700, 150);
		caFacts2.setForeground(new Color(53, 122, 127));
		caFacts2.setFont(new Font("Calibri", Font.PLAIN, 30));
		caFacts2.setVisible(false);
		caFrame.add(caFacts2);

		final JButton facts = new JButton("");
		facts.setBounds(720, 290, 153, 52);
		facts.setIcon(new ImageIcon(img6));
		facts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JButton buttonPressed = (JButton) actionEvent.getSource();
				if (_lastButtonPressed == buttonPressed)
				{
					caFrame.remove(caFacts);
					caFrame.revalidate();
					caFrame.repaint();
					caFacts2.setVisible(true);
				}
				caFacts.setVisible(true);
				_lastButtonPressed = buttonPressed;
			}
		});
		caFrame.setLayout(null);
		caFrame.add(facts);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(465, 190, 166, 103);
		lblNewLabel_6.setIcon(new ImageIcon(img7));
		caFrame.add(lblNewLabel_6);
		lblNewLabel.setIcon(new ImageIcon(img));
		caFrame.add(lblNewLabel);
	}
}
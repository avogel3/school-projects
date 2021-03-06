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

public class Frame3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 frame = new Frame3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 768);
		Image img = new ImageIcon(this.getClass().getResource("images/statebg.gif")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("images/ohio.gif")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("images/ohioState.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("images/clip.png")).getImage();
		contentPane.setLayout(null);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(317, 486, 680, 254);
		contentPane.add(tabbedPane);
		
		JLabel lblNewLabel_5 = new JLabel("<html><ul> <li> The Ohio River is the most polluted body of water in the United States. </li>"
				+ "<li> Ohio Depends on aquiphers as it's main source of drinking water.</li> "
				+ "<li> Ohio has more than 483000 acres of wetlands. </li>"
				+ "<li> Despite the Ohio River being heavily polluted, Ohio maintains a great water qulaity that exceeds federal standards. </li> </ul> </hmtl>");
		lblNewLabel_5.setForeground(new Color(0, 153, 255));
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		tabbedPane.addTab("Quick Facts", null, lblNewLabel_5, null);
		
		JLabel lblNewLabel_4 = new JLabel("<html> <a href=\"https://www.youtube.com/watch?v=Xu4SRlOdSQ4\">  Click here to watch a video about the water crisis in Ohio. </a> </html>");
		lblNewLabel_4.setBounds(326, 448, 389, 32);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(359, 273, 300, 152);
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(27, 246, 303, 328);
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(409, 145, 166, 103);
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);

		
		
	}
}

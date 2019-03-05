import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 *  Created by: Andrew Vogel
 */

public class Frame1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                Frame1 frame = new Frame1();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public Frame1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image img = new ImageIcon(this.getClass().getResource("/images/background.jpg")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/images/drops.png")).getImage();
		JButton button = new JButton();
		button.setLocation(828, 521);
		button.setIcon(new ImageIcon(img3));
		button.setSize(190, 199);
		button.addActionListener(arg0 -> {
            dispose();
            Frame2 newFrame = new Frame2();
            newFrame.setVisible(true);
        });
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		contentPane.add(button);
		Image img2 = new ImageIcon(this.getClass().getResource("/images/quote.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("/images/rain.gif")).getImage().getScaledInstance(250, 133, Image.SCALE_DEFAULT);
		Image img6 = new ImageIcon(this.getClass().getResource("/images/state.png")).getImage();
		JButton state_button = new JButton();
		state_button.setLocation(395, 85);
		state_button.setIcon(new ImageIcon(img6));
		state_button.setSize(208, 57);
		state_button.addActionListener(arg0 -> {
            dispose();
            Frame2 newFrame = new Frame2();
            newFrame.setVisible(true);
        });
		state_button.setBorderPainted(false);
		state_button.setFocusPainted(false);
		state_button.setContentAreaFilled(false);
		contentPane.add(state_button);
		
		Image img5 = new ImageIcon(this.getClass().getResource("/images/stream.gif")).getImage();
		Image img7 = new ImageIcon(this.getClass().getResource("/images/ak.gif")).getImage().getScaledInstance(240, 135, Image.SCALE_DEFAULT);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setLocation(342, 564);
		lblNewLabel_3.setSize(250, 133);
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setLocation(70, 562);
		lblNewLabel_6.setSize(240, 135);
		lblNewLabel_6.setIcon(new ImageIcon(img7));
		contentPane.add(lblNewLabel_6);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setLocation(81, 255);
		lblNewLabel_4.setSize(500, 282);
		lblNewLabel_4.setIcon(new ImageIcon(img5));
		contentPane.add(lblNewLabel_4);


		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setLocation(660, 226);
		lblNewLabel_1.setSize(280, 325);
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 740);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);

	}

}

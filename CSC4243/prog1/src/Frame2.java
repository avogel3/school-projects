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
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;

public class Frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
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
	public Frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 1024);
		//setBounds(100, 100, 768, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("bg2.jpg")).getImage();
		
		JButton btnGeorgia = new JButton("Georgia");
		btnGeorgia.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnGeorgia.setForeground(UIManager.getColor("info"));
		btnGeorgia.setBounds(525, 536, 117, 29);
		btnGeorgia.setBorderPainted(false); 
        btnGeorgia.setContentAreaFilled(false); 
        btnGeorgia.setFocusPainted(false); 
		btnGeorgia.setOpaque(false);
		contentPane.add(btnGeorgia);
		
		JButton btnOhio = new JButton("Ohio");
		btnOhio.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnOhio.setForeground(UIManager.getColor("info"));
		btnOhio.setBounds(494, 412, 117, 29);
		btnOhio.setBorderPainted(false); 
        btnOhio.setContentAreaFilled(false); 
        btnOhio.setFocusPainted(false); 
		btnOhio.setOpaque(false);
		btnOhio.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame3 ohio = new Frame3();
				ohio.setVisible(true);
			}
		});
		contentPane.add(btnOhio);
		
		JButton btnCalifornia = new JButton("California");
		btnCalifornia.setForeground(UIManager.getColor("info"));
		btnCalifornia.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCalifornia.setBounds(0, 412, 117, 29);
		contentPane.add(btnCalifornia);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 768, 1024);
		btnCalifornia.setBorderPainted(false); 
        btnCalifornia.setContentAreaFilled(false); 
        btnCalifornia.setFocusPainted(false); 
		btnCalifornia.setOpaque(false);
		contentPane.add(lblNewLabel);
	}

}

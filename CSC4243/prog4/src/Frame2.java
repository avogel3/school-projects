import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

/**
*  Created by: Andrew Vogel
*/

public class Frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                Frame2 frame = new Frame2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public Frame2() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setSize(1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image img = new ImageIcon(this.getClass().getResource("/images/background.jpg")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/images/intro.png")).getImage();

		Image california = new ImageIcon(this.getClass().getResource("/images/cali_2.png")).getImage().getScaledInstance(250, 377, Image.SCALE_DEFAULT);
		JButton cali_button = new JButton();
		cali_button.setLocation(90, 260);
		cali_button.setIcon(new ImageIcon(california));
		cali_button.setSize(250, 377);
		cali_button.addActionListener(arg0 -> {
			dispose();
			California newCali = new California();
			newCali.setVisible(true);
		});
		cali_button.setBorderPainted(false);
		cali_button.setFocusPainted(false);
		cali_button.setContentAreaFilled(false);
		contentPane.add(cali_button);

		Image florida = new ImageIcon(this.getClass().getResource("/images/fl_2.png")).getImage().getScaledInstance(250, 178, Image.SCALE_DEFAULT);
		JButton fl_button = new JButton();
		fl_button.setLocation(370, 300);
		fl_button.setIcon(new ImageIcon(florida));
		fl_button.setSize(250, 178);
		fl_button.addActionListener(arg0 -> {
			dispose();
			Florida newFl = new Florida();
			newFl.setVisible(true);
		});
		fl_button.setBorderPainted(false);
		fl_button.setFocusPainted(false);
		fl_button.setContentAreaFilled(false);
		contentPane.add(fl_button);

		Image louisiana = new ImageIcon(this.getClass().getResource("/images/la_2.png")).getImage().getScaledInstance(250, 226, Image.SCALE_DEFAULT);
		JButton la_button = new JButton();
		la_button.setLocation(650, 300);
		la_button.setIcon(new ImageIcon(louisiana));
		la_button.setSize(250, 226);
		la_button.addActionListener(arg0 -> {
			dispose();
			Louisiana newLA = new Louisiana();
			newLA.setVisible(true);
		});
		la_button.setBorderPainted(false);
		la_button.setFocusPainted(false);
		la_button.setContentAreaFilled(false);
		contentPane.add(la_button);

		Image maryland = new ImageIcon(this.getClass().getResource("/images/md_2.png")).getImage().getScaledInstance(250, 147, Image.SCALE_DEFAULT);
        JButton md_button = new JButton();
        md_button.setLocation(370, 500);
        md_button.setIcon(new ImageIcon(maryland));
        md_button.setSize(250, 147);
        md_button.addActionListener(arg0 -> {
            dispose();
            Maryland newMd = new Maryland();
            newMd.setVisible(true);
        });
        md_button.setBorderPainted(false);
        md_button.setFocusPainted(false);
        md_button.setContentAreaFilled(false);
        contentPane.add(md_button);

		Image michigan = new ImageIcon(this.getClass().getResource("/images/mi_2.png")).getImage().getScaledInstance(250, 236, Image.SCALE_DEFAULT);
        JButton mi_button = new JButton();
        mi_button.setLocation(650, 500);
        mi_button.setIcon(new ImageIcon(michigan));
        mi_button.setSize(250, 178);
        mi_button.addActionListener(arg0 -> {
            dispose();
            Michigan newMi = new Michigan();
            newMi.setVisible(true);
        });
        mi_button.setBorderPainted(false);
        mi_button.setFocusPainted(false);
        mi_button.setContentAreaFilled(false);
        contentPane.add(mi_button);



		JButton button = new JButton();
		button.setLocation(388, 87);
		button.setIcon(new ImageIcon(img2));
		button.setSize(201, 59);
		button.addActionListener(arg0 -> {
            dispose();
            Frame1 newFrame = new Frame1();
			newFrame.setVisible(true);
        });
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 740);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
	}

}
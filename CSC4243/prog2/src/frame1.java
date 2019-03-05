import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class Frame1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.

	/**
	 * Initialize the contents of the frame.
	 */
	public Frame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("images/background.gif")).getImage();
		
		JButton btnNewButton = new JButton("TAKE A TOUR");
		btnNewButton.setBounds(808, 645, 176, 72);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btnNewButton.setBackground(new Color(0, 153, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame2 newFrame = new Frame2();
				newFrame.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblHowDoesEach = new JLabel("How does each state stack up?");
		lblHowDoesEach.setBounds(189, 645, 541, 72);
		lblHowDoesEach.setFont(new Font("Iowan Old Style", Font.PLAIN, 36));
		lblHowDoesEach.setForeground(new Color(0, 153, 255));
		contentPane.add(lblHowDoesEach);
        Image info = new ImageIcon(this.getClass().getResource("images/waterInfo.jpg")).getImage();
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 768);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 303, 959, 330);
		scrollPane.setPreferredSize(new Dimension(629, 278));
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setColumnHeaderView(tabbedPane);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel jp1 = new JPanel();
		jp1.setBackground(new Color(255, 255, 255));
		JPanel jp2 = new JPanel();
		tabbedPane.addTab("Why Is It Important?", jp1);
		tabbedPane.setEnabledAt(0, true);
		jp1.setLayout(null);
		
		JLabel lblReasonWater = new JLabel("Reason 1: Water is a critical natural resource");
		lblReasonWater.setBounds(41, 20, 795, 24);
		lblReasonWater.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReasonWater.setForeground(new Color(0, 153, 255));
		jp1.add(lblReasonWater);
		
		JLabel lblReason = new JLabel("Reason #2:  Using less water keeps money in your pocket.  ");
		lblReason.setBounds(41, 63, 568, 30);
		lblReason.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReason.setForeground(new Color(0, 153, 255));
		jp1.add(lblReason);
		
		JLabel lblReason_1 = new JLabel("<html>Reason #3: Protecting our natural eco-systems from further damage is critical.</html>");
		lblReason_1.setBounds(41, 117, 752, 25);
		lblReason_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReason_1.setForeground(new Color(0, 153, 255));
		jp1.add(lblReason_1);
		
		JLabel lblReason_2 = new JLabel("Reason #4: Conserving water can also save energy.");
		lblReason_2.setBounds(41, 170, 486, 25);
		lblReason_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReason_2.setForeground(new Color(0, 153, 255));
		jp1.add(lblReason_2);
		
		JLabel lblReasonWater_1 = new JLabel("<html>Reason #5: Water conservation can reduce the occurrence of sink holes.</html>");
		lblReasonWater_1.setBounds(41, 218, 684, 25);
		lblReasonWater_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReasonWater_1.setForeground(new Color(0, 153, 255));
		jp1.add(lblReasonWater_1);
		
		JLabel lblReasonCleaner = new JLabel("Reason #6: Cleaner water means a healthier food chain. ");
		lblReasonCleaner.setBounds(41, 278, 539, 25);
		lblReasonCleaner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReasonCleaner.setForeground(new Color(0, 153, 255));
		jp1.add(lblReasonCleaner);
		
		JLabel lblReasonPoor = new JLabel("<html>Reason #7: Poor water quality tends to affect disadvantaged <br>communities disproportionately.</html>");
		lblReasonPoor.setBounds(41, 337, 574, 50);
		lblReasonPoor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReasonPoor.setForeground(new Color(0, 153, 255));
		jp1.add(lblReasonPoor);
		tabbedPane.addTab("Infographics", jp2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(info));
		jp2.add(lblNewLabel_1);
		
	}
}

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
import javax.swing.border.LineBorder;

public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(768, 1024);
		//frame.setBounds(100, 100, 768, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("background.gif")).getImage();
		
		JButton btnNewButton = new JButton("TAKE A TOUR");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btnNewButton.setBackground(new Color(0, 153, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(525, 840, 176, 73);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Frame2 newFrame = new Frame2();
				newFrame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblHowDoesEach = new JLabel("How does each state stack up?");
		lblHowDoesEach.setFont(new Font("Iowan Old Style", Font.PLAIN, 30));
		lblHowDoesEach.setForeground(new Color(0, 153, 255));
		lblHowDoesEach.setBounds(79, 852, 434, 42);
		frame.getContentPane().add(lblHowDoesEach);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(30, 297, 707, 507);
		JPanel jp1 = new JPanel();
		jp1.setBackground(new Color(255, 255, 255));
        JPanel jp2 = new JPanel();
        tabbedPane.addTab("Why Is It Important?", jp1);
        tabbedPane.setEnabledAt(0, true);
        SpringLayout sl_jp1 = new SpringLayout();
        jp1.setLayout(sl_jp1);
        
        JLabel lblReasonWater = new JLabel("Reason 1: Water is a critical natural resource");
        lblReasonWater.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblReasonWater.setForeground(new Color(0, 153, 255));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReasonWater, 20, SpringLayout.NORTH, jp1);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReasonWater, 41, SpringLayout.WEST, jp1);
        sl_jp1.putConstraint(SpringLayout.SOUTH, lblReasonWater, 44, SpringLayout.NORTH, jp1);
        sl_jp1.putConstraint(SpringLayout.EAST, lblReasonWater, -98, SpringLayout.EAST, jp1);
        jp1.add(lblReasonWater);
        
        JLabel lblReason = new JLabel("Reason #2:  Using less water keeps money in your pocket.  ");
        lblReason.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReason, 19, SpringLayout.SOUTH, lblReasonWater);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReason, 0, SpringLayout.WEST, lblReasonWater);
        sl_jp1.putConstraint(SpringLayout.SOUTH, lblReason, 49, SpringLayout.SOUTH, lblReasonWater);
        lblReason.setForeground(new Color(0, 153, 255));
        jp1.add(lblReason);
        
        JLabel lblReason_1 = new JLabel("<html>Reason #3: Protecting our natural eco-systems from <br> further damage is critical.</html>");
        lblReason_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReason_1, 24, SpringLayout.SOUTH, lblReason);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReason_1, 0, SpringLayout.WEST, lblReasonWater);
        lblReason_1.setForeground(new Color(0, 153, 255));
        jp1.add(lblReason_1);
        
        JLabel lblReason_2 = new JLabel("Reason #4: Conserving water can also save energy.");
        lblReason_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReason_2, 28, SpringLayout.SOUTH, lblReason_1);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReason_2, 0, SpringLayout.WEST, lblReasonWater);
        lblReason_2.setForeground(new Color(0, 153, 255));
        jp1.add(lblReason_2);
        
        JLabel lblReasonWater_1 = new JLabel("<html>Reason #5: Water conservation can reduce the occurrence of <br> sink holes.</html>");
        lblReasonWater_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReasonWater_1, 23, SpringLayout.SOUTH, lblReason_2);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReasonWater_1, 0, SpringLayout.WEST, lblReasonWater);
        lblReasonWater_1.setForeground(new Color(0, 153, 255));
        jp1.add(lblReasonWater_1);
        
        JLabel lblReasonCleaner = new JLabel("Reason #6: Cleaner water means a healthier food chain. ");
        lblReasonCleaner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblReasonCleaner.setForeground(new Color(0, 153, 255));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReasonCleaner, 35, SpringLayout.SOUTH, lblReasonWater_1);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReasonCleaner, 0, SpringLayout.WEST, lblReasonWater);
        jp1.add(lblReasonCleaner);
        
        JLabel lblReasonPoor = new JLabel("<html>Reason #7: Poor water quality tends to affect disadvantaged <br>communities disproportionately.</html>");
        lblReasonPoor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblReasonPoor.setForeground(new Color(0, 153, 255));
        sl_jp1.putConstraint(SpringLayout.NORTH, lblReasonPoor, 34, SpringLayout.SOUTH, lblReasonCleaner);
        sl_jp1.putConstraint(SpringLayout.WEST, lblReasonPoor, 0, SpringLayout.WEST, lblReasonWater);
        jp1.add(lblReasonPoor);
        tabbedPane.addTab("Infographics", jp2);
        
        JLabel lblNewLabel_1 = new JLabel("");
        Image info = new ImageIcon(this.getClass().getResource("waterInfo.jpg")).getImage();
        lblNewLabel_1.setIcon(new ImageIcon(info));
        jp2.add(lblNewLabel_1);
        frame.getContentPane().add(tabbedPane);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 768, 1024);
		frame.getContentPane().add(lblNewLabel);
		
	}
}

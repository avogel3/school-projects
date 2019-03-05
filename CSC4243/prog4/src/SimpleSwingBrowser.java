import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.invoke.MethodHandles;

/**
 *  Created by: Andrew Vogel
 */
public class SimpleSwingBrowser extends JFrame {

    private static void initAndShowGUI() {
        JFrame frame = new JFrame("FX");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setVisible(true);
        fxPanel.setSize(new Dimension(500, 300));
        fxPanel.setLocation(81, 255);
        frame.getContentPane().setPreferredSize(new Dimension(1024, 768));

        Image img = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/background.jpg")).getImage();
        Image img3 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/drops.png")).getImage();
        JButton button = new JButton();
        button.setLocation(828, 521);
        button.setIcon(new ImageIcon(img3));
        button.setSize(190, 199);
        button.addActionListener(arg0 -> {
            frame.dispose();
            Frame2 newFrame = new Frame2();
            newFrame.setVisible(true);
        });
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        contentPane.add(button);
        Image img2 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/quote.png")).getImage();
        Image img4 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/rain.gif")).getImage().getScaledInstance(250, 133, Image.SCALE_DEFAULT);
        Image img6 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/state.png")).getImage();
        JButton state_button = new JButton();
        state_button.setLocation(395, 85);
        state_button.setIcon(new ImageIcon(img6));
        state_button.setSize(208, 57);
        state_button.addActionListener(arg0 -> {
            frame.dispose();
            Frame2 newFrame = new Frame2();
            newFrame.setVisible(true);
        });
        state_button.setBorderPainted(false);
        state_button.setFocusPainted(false);
        state_button.setContentAreaFilled(false);
        contentPane.add(state_button);

        Image img5 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/stream.gif")).getImage();
        Image img7 = new ImageIcon(MethodHandles.lookup().lookupClass().getResource("/images/ak.gif")).getImage().getScaledInstance(240, 135, Image.SCALE_DEFAULT);

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


        frame.pack();
        Platform.runLater(() -> initFX(fxPanel));
    }

    /* Creates a WebView and fires up google.com */
    private static void initFX(final JFXPanel fxPanel) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webView = new WebView();

        group.getChildren().add(webView);
        webView.setMinSize(500, 300);

        // Obtain the webEngine to navigate
        WebEngine webEngine = webView.getEngine();
        String url = MethodHandles.lookup().lookupClass().getResource("index.html").toExternalForm();
        webEngine.load(url);
    }

    /* Start application */
    public static void main(final String[] args) {
        System.out.println("made it to main");
        SwingUtilities.invokeLater(SimpleSwingBrowser::initAndShowGUI);
    }
}
/**
 * Created by Zackery on 3/2/2016.
 */
import com.illposed.osc.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Receiver {

    public static void main(String[] args) throws java.net.SocketException {
        int receiverPort = 8000;
        OSCPortIn receiver = new OSCPortIn(receiverPort);

        OSCListener handler1 = new OSCListener() {
            public void acceptMessage(java.util.Date time, OSCMessage message) {
                //frame 1 is an application window - change dat
            	
            	Frame1 newFrame = new Frame1();
            	newFrame.setVisible(true);
            }
        };

        OSCListener handler2 = new OSCListener() {
            public void acceptMessage(java.util.Date time, OSCMessage message) {
            	// change image paths in this one
            	
    			Frame2 newFrame = new Frame2();
    			newFrame.setVisible(true);
 
                //JFrame frame = new JFrame();
                //frame.setSize(1024, 768);
                //JLabel label = new JLabel(new ImageIcon(image));
                //frame.add(label);
                //frame.setVisible(true);
            }
        };

        OSCListener handler3 = new OSCListener() {
            public void acceptMessage(java.util.Date time, OSCMessage message) {
                Frame3 newFrame = new Frame3();
                newFrame.setVisible(true);
            }
        };
        receiver.addListener("/1/Water Quality", handler1);
        receiver.addListener("/1/Minerals", handler2);
        receiver.addListener("/1/Phone Capture", handler3);

        System.out.println("Server is listening on port " + receiverPort + "...");
        receiver.startListening();

    }
}
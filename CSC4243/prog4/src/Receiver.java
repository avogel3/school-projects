/**
 * Created by Zackery on 3/2/2016.
 */
import com.illposed.osc.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class Receiver {

	public static void main(String[] args) throws java.net.SocketException {
		int receiverPort = 8000;
		OSCPortIn receiver = new OSCPortIn(receiverPort);

		OSCListener handler1 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Louisiana frame1 = new Louisiana();
				frame1.setVisible(true);
			}
		};

		OSCListener handler2 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Florida frame2 = new Florida();
				frame2.setVisible(true);
			}
		};

		OSCListener handler3 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Michigan frame3 = new Michigan();
				frame3.setVisible(true);
			}
		};

		OSCListener handler4 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Maryland frame4 = new Maryland();
				frame4.setVisible(true);
			}
		};

		OSCListener handler5 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				California frame5 = new California();
				frame5.setVisible(true);
			}
		};

		OSCListener handler6 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Frame1 frame5 = new Frame1();
				frame5.setVisible(true);
			}
		};

		OSCListener handler7 = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Frame2 frame6 = new Frame2();
				frame6.setVisible(true);
			}
		};

		receiver.addListener("/1/Louisiana", handler1);
		receiver.addListener("/1/Florida", handler2);
		receiver.addListener("/1/Michigan", handler3);
		receiver.addListener("/1/Maryland", handler4);
		receiver.addListener("/1/California", handler5);
		receiver.addListener("/1/Ssb", handler6);
		receiver.addListener("/1/Frame2", handler7);

		System.out.println("Server is listening on port " + receiverPort + "...");
		receiver.startListening();
	}
}
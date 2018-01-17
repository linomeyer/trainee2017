/*Beispiel mit Programmfenster
*/

import java.awt.*;
import javax.swing.*;

public class GrussMitProgrammfenster extends JFrame {
	public GrussMitProgrammfenster() {
		super("Hallo");
		
		Icon icom = new ImageIcon("java-logo.jpg");
		JLabel label1 = new JLabel("Viel Erfolg beim", JLabel.CENTER);
		JLabel label2 = new JLabel("Programmieren mit Java!", JLabel.CENTER);
		JLabel label3 = new JLabel(icom);
		Font schrift = new Font("SansSerif", Font.BOLD, 24);
		label1.setFont(schrift);
		label1.setForeground(Color.red);
		label2.setFont(schrift);
		label2.setForeground(Color.red);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.white);
		c.add(label1);
		c.add(label2);
		c.add(label3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(684,513);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new GrussMitProgrammfenster();
	}
}
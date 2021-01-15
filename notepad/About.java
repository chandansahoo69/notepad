package notepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
	JButton b1;
	About(){
		setBounds(400, 200, 420, 300);
		setLayout(null);
		//get the image path 
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/windows.png"));
////		set the size of the image
//		Image i2 = i1.getImage().getScaledInstance(400, 80, Image.SCALE_DEFAULT);
////		make it to imageicon bcz image will not taken by jlabel 
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel l1 = new JLabel(i3);
//		l1.setBounds(150, 40, 400, 40);
//		add(l1);
		
		JLabel l3 = new JLabel("<html>Chandan Sahoo<br>Version 2021<br>ck, All Rights Reserved<br><br>Notepad is a word processing program<br>which allows to updating text in a text file<br>Notepad is a Basic text editing program.</html>");
		l3.setBounds(70, 30, 300, 200);
		l3.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
		add(l3);
		
		b1 = new JButton("OK");
		b1.setBounds(150, 235, 80, 20);
		b1.addActionListener(this);
		add(b1);
	}
	
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		new About().setVisible(true);
	}
}

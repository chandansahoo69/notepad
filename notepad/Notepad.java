package notepad;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
	
	JTextArea area;
	JScrollPane pane;
	//to store the copied data
	String text;
	Notepad() {
		//x position, y position, frame width, frame height
		setBounds(0, 0, 1950, 1050);
		//create a menu bar
		JMenuBar menubar = new JMenuBar();
		//create some menu option 
		JMenu file = new JMenu("File");
		
		//creating some menu items like save, open, new, exit... 
		
		JMenuItem newdoc = new JMenuItem("New");
		//set the action which performed by ctrl + n to create new file 
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//add an event 
		newdoc.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		//set the action which performed by ctrl + o to open file 
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		//add an event 
		open.addActionListener(this);
		
		JMenuItem save = new JMenuItem("Save");
		//set the action which performed by ctrl + s to save file 
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		//add an event 
		save.addActionListener(this);
		
		JMenuItem print = new JMenuItem("Print");
		//set the action which performed by ctrl + p to print file 
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		//add an event 
		print.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit");
		//set the action which performed by escape  
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		//add an event 
		exit.addActionListener(this);
		
		//add the items into the file menu
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		//adding the adit menu
		JMenu edit = new JMenu("Edit");
		
		JMenuItem copy = new JMenuItem("Copy");
		//set the action which performed by ctrl + c to copy text 
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		//add an event 
		copy.addActionListener(this);
		
		JMenuItem paste = new JMenuItem("Paste");
		//set the action which performed by ctrl + n to paste text
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		//add an event 
		paste.addActionListener(this);
		
		JMenuItem cut = new JMenuItem("Cut");
		//set the action which performed by ctrl + n to cut text 
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		//add an event 
		cut.addActionListener(this);
		
		JMenuItem selectall = new JMenuItem("Select All");
		//set the action which performed by ctrl + n to create new file 
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		//add an event 
		selectall.addActionListener(this);
		
		//add all the items to edit
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(selectall);
		
		//ading the help menu
		JMenu help = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About The Notepad");
		//add an event 
		about.addActionListener(this);
		
		//adding in help menu
		help.add(about);
		
		//add the menu option on menu bar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		//add(menu bar) in the frame;
		setJMenuBar(menubar);
		
		
		//adding a text area to write
		area = new JTextArea();
		area.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		//to break the line in the next line
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		//add the area in the pane
		pane = new JScrollPane(area);
		//to remove the default border
		pane.setBorder(BorderFactory.createEmptyBorder());
		
		add(pane, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New")) {
			//when press new then clear the text 
			area.setText("");
		} else if(ae.getActionCommand().equals("Open")) {
			//if we pass the location then it will 
			//it basically show the dialog box
			JFileChooser chooser = new JFileChooser("D:");
			chooser.setAcceptAllFileFilterUsed(false);
			//we are restrict only txt file
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
			//add the restriction to the chooser
			chooser.addChoosableFileFilter(restrict);
			
			//show the dialog box to save or cancel the file 
			int action = chooser.showOpenDialog(this);
			//if it is cancel then return 
			if(action != JFileChooser.APPROVE_OPTION) {
				return ;
			}
			//which file user will select that stored in file variable
			File file = chooser.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				area.read(reader, null);
			} catch(Exception e) {
				
			}

			
		} else if(ae.getActionCommand().equals("Save")) {
			//we have to create an object of file chooser to save files
			//it basically show the dialog box
			JFileChooser saveas = new JFileChooser();
			saveas.setApproveButtonText("Save");
			//show the dialog box to save or cancel the file 
			int action = saveas.showOpenDialog(this);
			//if it is cancel then return 
			if(action != JFileChooser.APPROVE_OPTION) {
				return ;
			}
			//get the file name and add .txt file extension
			File filename = new File(saveas.getSelectedFile() + ".txt");
			BufferedWriter outfile = null;
			try {
				//fetch the file 
				outfile = new BufferedWriter(new FileWriter(filename));
				//take the texts from write it in the file 
				area.write(outfile);
			} catch(Exception e) {
				
			}
		} else if(ae.getActionCommand().equals("Print")) {
			try {
				area.print();
			} catch(Exception e) {}
		} else if(ae.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if(ae.getActionCommand().equals("Copy")) {
			//it will select the selected text
			text = area.getSelectedText();
		} else if(ae.getActionCommand().equals("Paste")) {
			//what we have to paste and where the position 
			area.insert(text, area.getCaretPosition());
		} else if(ae.getActionCommand().equals("Cut")) {
			//take the selected text
			text = area.getSelectedText();
			//replace the selected text to blank and from start to end of 
			//the selection
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
		} else if(ae.getActionCommand().equals("Select All")) {
			area.selectAll();
		} else if(ae.getActionCommand().equals("About The Notepad")) {
			new About().setVisible(true);
		}
	}

	public static void main(String[] args) {
			new Notepad().setVisible(true);	
	}

}

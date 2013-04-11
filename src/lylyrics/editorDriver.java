package lylyrics;
import java.awt.Color;

import javax.swing.*;
public class editorDriver extends JFrame{

	

	public editorDriver()
	{
		
		editorpanel bcd = new editorpanel();
		this.setTitle("Lyrics Editor");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		menu abc = new menu(bcd);
		editorToolbar xyz = new editorToolbar(bcd);
		this.getContentPane().add(xyz,null);
		xyz.setBounds(10, 5, 500, 30);
		
		setJMenuBar(abc);
		this.setVisible(true);
		this.setSize(500,500);
		setLayout(null);
		bcd.setBounds(10, 60, 500 , 400);
		this.getContentPane().add(bcd);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	
	
	
}
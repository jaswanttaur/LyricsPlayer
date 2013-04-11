package lylyrics;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;


public class find extends JFrame{
	JPanel p2 = new JPanel();
	JPanel p1 = new JPanel();
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JLabel l1 = new JLabel("Search");
	JLabel l2 = new JLabel("Replace With");
	JLabel l3 = new JLabel("Scope of Search");
	JCheckBox ch1 = new JCheckBox("All");
	JCheckBox ch2 = new JCheckBox("Selected");
	//JCheckBoxGroup chg = new JCheckBoxGroup();
	JButton b1 = new JButton("Find");
	JButton b2 = new JButton("Find Next");
	JButton b3 = new JButton("Find Previous");
	JButton b4 = new JButton("Replace");
	JButton b5 = new JButton("Replace All");
	editorpanel ed;
	
	
	public find(editorpanel ed)
	
	{	//JCheckBox ch1 = new JCheckBox("All",cbg,true);
		this.setResizable(false);
		this.setTitle("Find");
		this.ed = ed;
		this.setVisible(true);
		this.setSize(450,300);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(p1);
		p1.setVisible(true);
		p1.setLayout(null);
		
		
		l1.setBounds(40,60,50,20);
		p1.add(l1); 
		f1.setBounds(110, 60, 100, 20);
		p1.add(f1);
		
		
		l2.setBounds(40, 100, 80,20);
		p1.add(l2);
		
		f2.setBounds(110,100,100,20);
		p1.add(f2);
		
		
		b1.setBounds(40,140,70,20);
		b2.setBounds(130, 140, 90, 20);
		p1.add(b1);
		p1.add(b2);
		
		
		b3.setBounds(235, 140, 90,20);
		p1.add(b3);
		
		b4.setBounds(40, 170, 70, 20);
		p1.add(b4);
		
		b5.setBounds(130,170,90,20);
		p1.add(b5);
		
		p2.setBounds(300, 50, 100, 80);
		p2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		p1.add(p2);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(l3);
		p2.add(ch1);
		p2.add(ch2);
		
		
	}
	
	
}

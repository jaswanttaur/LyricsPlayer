package lylyrics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class prefs extends JFrame implements ActionListener {
	JPanel pref1 = new JPanel();
	JToolBar preftool = new JToolBar();
	JButton b1 = new JButton("Lyrics");
	JButton b2 = new JButton("Advanced");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel l1 = new JLabel("Save Lyrics in");
	JLabel advanced = new JLabel("Advanced Setting");
	JCheckBox samename = new JCheckBox("Use Same Name as Song");
	public prefs()
	{	
		this.setTitle("Prefrences");
		this.setSize(400, 350);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//toolbar added
		this.getContentPane().add(preftool);
		
		//toolbar buttons
		preftool.add(b1);
		preftool.add(b2);
		preftool.setBounds(0, 0, 400, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		//panel 1
		this.getContentPane().add(p1);
		p1.setBounds(0, 35, 400,300 );
		

		
		l1.setBounds(42, 20, 70, 30);
		p1.add(l1);
		p1.setLayout(null);
		samename.setBounds(20, 50, 250, 25);
		p1.add(samename);
		
		//panel 2
		this.getContentPane().add(p2);
		p2.setBounds(0, 35, 400,300 );
		p2.setVisible(false);
		p2.setLayout(null);
		
		advanced.setBounds(43, 50, 100, 30);
		p2.add(advanced);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == b1)
		{
			p1.setVisible(true);
			p2.setVisible(false);
			
		}
		else if(arg0.getSource() == b2)
		{
			p1.setVisible(false);
			p2.setVisible(true);
		}
	}

}

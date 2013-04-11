package lylyrics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class viewerDriver extends JFrame implements MouseListener{

	static JTextArea jt;
	JScrollPane scpane = new JScrollPane();
	JPopupMenu Pmenu;
	JMenuItem menuItem;
	
	public viewerDriver()
	{	
		
		this.setVisible(true);
		this.setTitle("Lyrics Player");
		this.setSize(550,400);
		//this.setResizable(false);
		setLayout(null);
		
		this.setLocationRelativeTo(null);
		
		
		/*Pmenu = new JPopupMenu();
		  menuItem = new JMenuItem("LyricsEditor");
		  Pmenu.add(menuItem);
		  menuItem = new JMenuItem("Copy");
		  Pmenu.add(menuItem);
		  menuItem = new JMenuItem("Paste");
		  Pmenu.add(menuItem);
		  menuItem = new JMenuItem("Delete");
		  Pmenu.add(menuItem);
		  menuItem = new JMenuItem("Undo");
		  Pmenu.add(menuItem);
		  menuItem.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){}
		  });*/
		jt = new JTextArea();
		scpane.setViewportView(jt);
		
		java.awt.Font font = new java.awt.Font("Arial Unicode MS", java.awt.Font.PLAIN, 16);
	    jt.setFont(font);
		
		viewermenu vmenu = new viewermenu();
		setJMenuBar(vmenu);
		
	       /*	viewertoolbar vtool = new viewertoolbar();
		vtool.setBounds(10, 5, 500,30);
		this.getContentPane().add(vtool,null);
		*/
                
		scpane.setBounds(2,20,this.getWidth()-20,this.getHeight()-50);
		//this.add(scpane);
		scpane.setEnabled(true);
		jt.setText(sql_con_search.lyr);
		this.getContentPane().add(scpane,null);
	/*	jt.addMouseListener(new MouseAdapter(){
			  public void mouseReleased(MouseEvent Me){
				  if(Me.isPopupTrigger()){
				  Pmenu.show(Me.getComponent(), Me.getX(), Me.getY());
				  }
				  }
				  });
	/*	try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("d:\\");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  System.out.println (strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }*/
		jt.setEditable(false);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}

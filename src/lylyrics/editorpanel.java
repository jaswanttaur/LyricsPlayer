package lylyrics;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class editorpanel extends JPanel {
    
    
	JLabel l1 = new JLabel("Artist");
	JLabel l2 = new JLabel("Title");
	JLabel l3 = new JLabel("Album");
	JLabel l4 = new JLabel("Edited By");
	JLabel l5 = new JLabel("Media Length");
	JLabel l6 = new JLabel("Delay (ms)");
	JTextArea tarea = new JTextArea(); 
	JScrollPane jsp = new JScrollPane(tarea);
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f5 = new JTextField();
	JTextField f6 = new JTextField();
	JScrollPane scpane = new JScrollPane();
	
	Color color= Color.gray;
		

	

	
	public editorpanel()
	{	
		viewerDriver vv = null;
	    java.awt.Font font = new java.awt.Font("Arial Unicode MS", java.awt.Font.PLAIN, 18);
	    tarea.setFont(font);
	    tarea.setText(vv.jt.getText());
	    f1.setFont(font);
	    f2.setFont(font);
	    f3.setFont(font);
	    f4.setFont(font);
	    f5.setFont(font);
	    f6.setFont(font);
	    
	
		this.setLayout(null);
		scpane.setViewportView(tarea);
		Rectangle rec = new Rectangle(12,12,450,430);
		scpane.setBounds(0,0, 480, 270);
		tarea.scrollRectToVisible(rec);
		l1.setBounds(0, 280,70 , 20);
		l2.setBounds(0, 310, 70, 20);
		l3.setBounds(0, 340, 70, 20);
		l4.setBounds(250, 280, 70, 20);
		l5.setBounds(250, 310, 70, 20);
		l6.setBounds(250, 340, 70, 20);
		
		
		f1.setBounds(75,280,100,20);
		f2.setBounds(75,310,100,20);
		f3.setBounds(75,340,100,20);
		f4.setBounds(325,280,100,20);
		f5.setBounds(325,310,100,20);
		f6.setBounds(325,340,100,20);
		add(scpane);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(f6);
	sql_con_search sq = null;
	try{
		  // Open the file that is the first 
		  // command line parameter
		  FileInputStream fstream = new FileInputStream("d:\\"+sq.ta.getValueAt(sq.row, 1)+".lrc");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
			  tarea.setText(strLine);
		  System.out.println (strLine);
		  }
		  //Close the input stream
		  in.close();
		    }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
		
	}
	
	
	

}

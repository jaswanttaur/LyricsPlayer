package lylyrics;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

public class viewermenu extends JMenuBar implements ActionListener {
    
               viewerDriver vd;
	
	JMenu m1 = new JMenu("Lyrics");
	JMenu m2 = new JMenu("View");
	JMenu m3 = new JMenu("Options");
        
        	Connection con;
	Statement sta;
        editorpanel ed;
       
	
	
	
	JMenuItem save = new JMenuItem("Save Lyrics");
	JMenuItem saveas = new JMenuItem("Save As Lyrics");
	JMenuItem savesong = new JMenuItem("Save Lyrics In Song File");
	JMenuItem up = new JMenuItem("Upload Lyrics");
	JMenuItem charencoding = new JMenuItem("Character Encoding");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem search = new JMenuItem("Lyrics Search");
	JMenuItem rate = new JMenuItem("Rate this Lyrics");
	JMenuItem r5 = new JMenuItem("5 (HIGH)");
	JMenuItem r4 = new JMenuItem("4");
	JMenuItem r3 = new JMenuItem("3");
	JMenuItem r2 = new JMenuItem("2");
	JMenuItem r1 = new JMenuItem("1 (LOW)");
	JMenuItem lyricsdown = new JMenuItem("Lyrics Downloader");
	JMenuItem lyricsedit = new JMenuItem("Lyrics Editor");
	JMenuItem floatly = new JMenuItem("Floating Lyrics");
	JMenuItem pref = new JMenuItem("Preferences");
	JMenuItem hue = new JMenuItem("Adjust Hue");
	
	JMenuItem abt = new JMenuItem("About");
	JMenuItem helpp = new JMenuItem("Help");
	JMenuItem web = new JMenuItem("Author Website");
	JMenuItem act = new JMenuItem("Activate");
        
        JMenuItem color = new JMenuItem("Lyrics Color");	
	JMenuItem bgcolor = new JMenuItem("Background Color");
	
	
	Color colorch = Color.white;
	Color colortxt = Color.black;
	
	
public viewermenu()
	{
		
         this.add(m1);
         this.add(m2);
         this.add(m3);
         
       
	//lyrics menu
         m1.add(search);
         //m1.addSeparator();
        // m1.add(rate);
         //m1.add(up);
         //m1.addSeparator();
         //m1.add(savesong);
         //m1.addSeparator();
        // m1.add(save);
         
         //m1.add(saveas);
         //m1.addSeparator();
         //m1.add(charencoding);
         m1.addSeparator();
         m1.add(exit);
   
		//view menu
     m2.add(lyricsdown);
       m2.add(lyricsedit);

         //m2.add(floatly);
         //m2.add(pref);
        // m2.addSeparator();
         //m2.add(hue);
         //m2.addSeparator();
         

         
      
         
         //help menu*/
         
         //m3.add(abt);
         //m3.add(helpp);
         //m3.addSeparator();
         //m3.add(web);
         //m3.addSeparator();
        //m3.add(act);
         m3.add(color);
         //options.add(hcolor);
         //options.add(blcolor);
         m3.add(bgcolor); 
         
         lyricsdown.addActionListener(this);
         lyricsedit.addActionListener(this);
         pref.addActionListener(this);
         search.addActionListener(this);
         bgcolor.addActionListener(this);
         color.addActionListener(this);
         
         
         
         exit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {     	
        System.exit(0);

    }
});
		
	}





@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource() == lyricsedit)
	{
	
		editorDriver editor = new editorDriver();
	}
	else if (arg0.getSource() == pref)
	{
		prefs prefrence = new prefs();
	}
	else if(arg0.getSource() == search)
	{
		new sql_con_search();
                
	}
        	else if(arg0.getSource() == lyricsdown)
	{
		new sql_con_search();
                
	}
        else if(arg0.getSource() == bgcolor)
	{           
		colorch = JColorChooser.showDialog( this, "Choose a color", colorch);
		vd.jt.setBackground(colorch);
	}
                else if(arg0.getSource() == color)
	{
		colortxt = JColorChooser.showDialog( this, "Choose a color", colortxt);
		vd.jt.setForeground(colortxt);
	}  
        else if(arg0.getSource() == up)
	{
	       try{
               Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/lyrics?useUnicode=true&characterEncoding=utf8","root","");                                  								
      sta=con.createStatement();
sta.executeUpdate("insert into lyrics (title,artist,album,delay,editedBy,mediaLength,lyrics) values ('"+ed.f2.getText()+"','"+ed.f1.getText()+"','"+ed.f3.getText()+"','"+ed.f6.getText()+"','"+ed.f4.getText()+"','"+ed.f5.getText()+"','"+ed.tarea.getText()+"')");
                             sta.close();
                       con.close();
                      JOptionPane.showMessageDialog(this,"Uploaded!");
      } 
      catch(Exception ex){
          JOptionPane.showMessageDialog(this,ex.getMessage());
      }
	      
	}

}
}

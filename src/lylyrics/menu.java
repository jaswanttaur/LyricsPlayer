package lylyrics;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class menu extends JMenuBar implements ActionListener {

	editorpanel ed;
	editorDriver edd;
	JMenu file = new JMenu("file");
	JMenu edit = new JMenu("edit");
	JMenu play = new JMenu("play");
	JMenu lyricss = new JMenu("lyrics");
	JMenu options = new JMenu("options");
	JMenu help = new JMenu("help");
	
	
	JMenuItem n = new JMenuItem("New Lyrics");
	JMenuItem open = new JMenuItem("Open Lyrics");
	JMenuItem save = new JMenuItem("Save As Lyrics");
	JMenuItem saveas = new JMenuItem("Save Lyrics");
	JMenuItem up = new JMenuItem("Upload Lyrics");
	JMenuItem charencoding = new JMenuItem("Character Encoding");

	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem playpause = new JMenuItem("Play/Pause");

	JMenuItem next = new JMenuItem("Next");
	JMenuItem previous = new JMenuItem("Previous");
	JMenuItem forw = new JMenuItem("Forward 2 sec");
	JMenuItem backw = new JMenuItem("Backward 2 sec");
	JMenuItem jump = new JMenuItem("Jump");
	JMenuItem undo = new JMenuItem("Undo");
	JMenuItem redo = new JMenuItem("Redo");
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste = new JMenuItem("Paste");
	JMenuItem find = new JMenuItem("Find");
	JMenuItem replace = new JMenuItem("Replace");
	JMenuItem del = new JMenuItem("Delete");
	JMenuItem abt = new JMenuItem("About");
	JMenuItem helpp = new JMenuItem("Help");
	JMenuItem web = new JMenuItem("Author Website");
	JMenuItem color = new JMenuItem("Lyrics Color");
	JMenuItem hcolor = new JMenuItem("Highlight Color");
	JMenuItem bgcolor = new JMenuItem("Background Color");
	
	JMenuItem blcolor = new JMenuItem("Background Line Color");
	JMenuItem syn = new JMenuItem("Synchronization of Current Line");
	JMenuItem remt = new JMenuItem("Remove TimeStamp");
	JMenuItem forwt = new JMenuItem("Forward TimeStamp");
	JMenuItem backt = new JMenuItem("Backward TimeStamp");
	
	Color colorch = Color.white;
	Color colortxt = Color.black;
	
	
	Connection con;
	Statement sta;
	editorpanel ee;
        
        viewerDriver vd = null;
        
	
public menu(editorpanel ed)
	{
	     this.ed = ed;
	     
		 this.add(file);
         //this.add(play);
         this.add(edit);
         //this.add(lyricss);
         this.add(options);
         //this.add(help);
		
	//file menu
         file.add(up);
         up.addActionListener(this);
         file.add(n);
         n.addActionListener(this);
         file.add(open);
         open.addActionListener(this);
                  file.add(saveas);
         saveas.addActionListener(this);
         file.add(save);
         save.addActionListener(this);

         //file.add(charencoding);
         file.add(exit);
   
		//play menu
         play.add(playpause);
         play.add(next);
         play.add(previous);
         play.add(forw);
         play.add(backw);
         play.add(jump);
         
         
         //edit menu
         edit.add(undo);
         edit.add(redo);
         edit.add(cut);
         edit.add(copy);
         edit.add(paste);
         edit.add(del);
         //edit.add(find);
         //edit.add(replace);
         
         //lyrics menu
         
         lyricss.add(syn);
         lyricss.add(forwt);
         lyricss.add(backt);
         lyricss.add(remt);
         
         
         //option menu
         
         options.add(color);
         //options.add(hcolor);
         //options.add(blcolor);
         options.add(bgcolor);
        
         
         //help menu
         
         help.add(abt);
         help.add(helpp);
         help.add(web);
         
         cut.addActionListener(this);
         copy.addActionListener(this);
         paste.addActionListener(this);
         find.addActionListener(this);
         bgcolor.addActionListener(this);
         color.addActionListener(this);
         
         /*shortcuts*/
         //new
n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
n.addActionListener(new ActionListener() 
{
	  		editorpanel ed = new editorpanel();
	  		public void actionPerformed(ActionEvent e) {
       	ed.tarea.setText("");
	 		ed.f1.setText("");
	 		ed.f2.setText("");
	 		ed.f3.setText("");
	 		ed.f4.setText("");
	 		ed.f5.setText("");
	 		ed.f6.setText("");

}
});
    //open
open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
open.addActionListener(new ActionListener() 
{
	 public void actionPerformed(ActionEvent e){
		 editorpanel ed = new editorpanel();
		 new filechooser(ed);	 
}
}); 
	//save
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
save.addActionListener(new ActionListener() 
{
	 public void actionPerformed(ActionEvent e){
		 editorpanel ed = new editorpanel();
		 new save(ed.tarea.getText());	 
}
});
	//exit
exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
        InputEvent.ALT_MASK));
exit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {     	
        System.exit(0);
    }
});
	//cut
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
cut.addActionListener(new ActionListener() 
{
	 public void actionPerformed(ActionEvent e){
		 editorpanel ed = new editorpanel();
		 ed.tarea.cut();	 
}
});
	//copy
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
copy.addActionListener(new ActionListener() 
{
	 public void actionPerformed(ActionEvent e){
		 editorpanel ed = new editorpanel();
		 ed.tarea.copy();	 
}
});
	//paste
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
paste.addActionListener(new ActionListener() 
{
	 public void actionPerformed(ActionEvent e){
		 editorpanel ed = new editorpanel();
		 ed.tarea.paste();	 
}
});

    
         
	}




@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource()== open)
	{
		new filechooser(ed);
	}
	else if (arg0.getSource() == save)
	{
		new save(ed.tarea.getText());
                vd.jt.setText(ed.tarea.getText());
	}
	else if(arg0.getSource() == n)
	{
		ed.tarea.setText("");
		ed.f1.setText("");
		ed.f2.setText("");
		ed.f3.setText("");
		ed.f4.setText("");
		ed.f5.setText("");
		ed.f6.setText("");
		
	}
	else if (arg0.getSource() == copy)
	{
		ed.tarea.copy();
	}
	else if (arg0.getSource() == cut)
	{
		ed.tarea.cut();
	}
	else if (arg0.getSource() == paste)
	{
		ed.tarea.paste();
	}
	else if (arg0.getSource() == find)
	{
		new find(ed);
	}
	else if (arg0.getSource() == bgcolor)
	{
		colorch = JColorChooser.showDialog( this, "Choose a color", colorch);
		ed.tarea.setBackground(colorch);
	
	}
	else if (arg0.getSource() == color)
	{	colortxt = JColorChooser.showDialog( this, "Choose a color", colortxt);
		ed.tarea.setForeground(colortxt);
	}
        	else if (arg0.getSource() == saveas)
	{	
        vd.jt.setText(ed.tarea.getText());
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

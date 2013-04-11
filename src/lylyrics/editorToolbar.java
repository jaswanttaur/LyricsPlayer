package lylyrics;
import javax.swing.*;
import java.util.Timer;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.media.Player;
import lyplayer.JumpForm;
public class editorToolbar extends JToolBar implements ActionListener {
	
	JButton openbutton = new JButton(new ImageIcon("icon/open.jpg"));
        
        //openbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.jpg")));
	JButton copybutton = new JButton(new ImageIcon("icon/copy.jpg"));
	JButton timerbutton = new JButton("icon/timer.jpg"); 
	//JButton timerbutton = new JButton(new ImageIcon("timer.jpg")); 
	JButton newbutton = new JButton(new ImageIcon("icon/new.jpg"));
	JButton savebutton = new JButton(new ImageIcon("icon/save.jpg"));
	JButton saveasbutton = new JButton(new ImageIcon("icon/saveas.jpg"));
	JButton playbutton = new JButton(new ImageIcon("icon/play.jpg"));
	JButton pausebutton = new JButton(new ImageIcon("icon/pause.jpg"));
	JButton backwardbutton = new JButton(new ImageIcon("icon/backward.jpg"));
	JButton forwardbutton = new JButton(new ImageIcon("icon/forward.jpg"));
	JButton cutbutton = new JButton(new ImageIcon("icon/cut.jpg"));
	JButton pastebutton = new JButton(new ImageIcon("icon/paste.jpg"));
	JButton searchbutton = new JButton(new ImageIcon("icon/search.jpg"));
	editorpanel ed;
        Player pp;
        JumpForm jj;
	 
  public editorToolbar(editorpanel ed) {
  
	 this.ed = ed;
  //this.add(timerbutton);
  
  this.add(newbutton);
  this.add(openbutton);
  
  //this.add(savebutton);
  
  this.add(saveasbutton);
 
  //this.add(playbutton);
  
  //this.add(pausebutton);
  
  //this.add(backwardbutton);
  
  //this.add(forwardbutton);
  
  this.add(cutbutton);
  
  this.add(copybutton);
  
  this.add(pastebutton);
  
  //this.add(searchbutton);
  
  
  
  //actionlisteners
  openbutton.addActionListener(this);
  cutbutton.addActionListener(this);
  pastebutton.addActionListener(this);
  copybutton.addActionListener(this);
  forwardbutton.addActionListener(this);
  backwardbutton.addActionListener(this);
  playbutton.addActionListener(this);
  
  newbutton.addActionListener(this);
  savebutton.addActionListener(this);
  saveasbutton.addActionListener(this);
  timerbutton.addActionListener(this);
  searchbutton.addActionListener(this);
  }

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	if(arg0.getSource() == timerbutton)
	{
		//timerbutton.setLabel("time==="+JavaWMP.time);

                //timerbutton.setLabel(pp.min + " : " + pp.sec );
           
                    try {
                        
                        Double min, sec,timing;
        min = Double.parseDouble(jj.txtMinute.getText()) * 60;
        sec = Double.parseDouble(jj.txtSecond.getText());

                         
       
        }
        catch (Exception e) {
            
        }


	}
	else if(arg0.getSource() == cutbutton)
	{
		ed.tarea.cut();
	}
	else if(arg0.getSource() == copybutton)
	{
		ed.tarea.copy();
	}
	else if(arg0.getSource() == pastebutton)
	{
		ed.tarea.paste();
	}
	else if(arg0.getSource() == newbutton)
	{
		ed.tarea.setText("");
		ed.f1.setText("");
		ed.f2.setText("");
		ed.f3.setText("");
		ed.f4.setText("");
		ed.f5.setText("");
		ed.f6.setText("");
		
	}
	
	else if(arg0.getSource() == openbutton)
	{
		new filechooser(ed);
	}
	
	
	else if(arg0.getSource() == saveasbutton)
	{
		new save(ed.tarea.getText());
	}
	
	
}
	
}


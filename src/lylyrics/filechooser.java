package lylyrics;
import javax.swing.*;
import java.io.*;
class filechooser extends JFrame
{	
	
	String name = "";
	JFileChooser filech = new JFileChooser();
	String str="";
	editorpanel ed;
	public filechooser(editorpanel ed) 
	{
		this.ed = ed;
		
		if(filech.showOpenDialog(this)==filech.OPEN_DIALOG);
		{
			
		name = String.valueOf(filech.getSelectedFile());
		
		try
		{
		File infile = new File(name);
		FileReader fr = new FileReader(infile);
		int ch;
		
		while((ch = fr.read())!=-1)
		{
			
			 str+= String.valueOf((char)ch);
			
				
			
		}
		ed.tarea.setText( str);
		
		}
		catch(Exception e){JOptionPane.showConfirmDialog(null, e.getMessage());}
		}
		
		
	}
	}
	
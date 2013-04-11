package lylyrics;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class save extends JFrame 
{	editorpanel ed = new editorpanel();
	String s,name;
	public save(String s)
	{		name = ed.f3.getText();
		try
		{
			this.s = s;// panel.tarea.getText();
			if(s.length()>0)
			{
				FileDialog fd= new FileDialog(this,"Save File As",FileDialog.SAVE);
				fd.setFile("abc.txt");
				//fd.setDirectory("c:\\windows\\temp");
				fd.setVisible(true);
				String path=fd.getDirectory()+fd.getFile();

				FileOutputStream fos=new FileOutputStream(path);
				//System.out.println(s);
				byte[] b=s.getBytes();
				fos.write(b);
				fos.close();
}
}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
}



package lylyrics;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class sql_con_search extends JFrame implements ActionListener,MouseListener,InputMethodListener{

	JButton b;
JScrollPane sp;
JTable t;
String d1,d2,d3;
Connection con;
Statement sta;
ResultSet rs;
JLabel titleLabel,artistLabel,albumLabel;
JTextField titleTextField,artistTextField,albumTextField;
DefaultTableModel model;
String fn,substring,lyrics;
public  sql_con_search(){
	java.awt.Font font = new java.awt.Font("Arial Unicode MS", java.awt.Font.PLAIN, 12);
        sp = new javax.swing.JScrollPane();
        t = new javax.swing.JTable();
        b = new javax.swing.JButton();
        
        titleLabel = new javax.swing.JLabel("Title");
        artistLabel = new javax.swing.JLabel("Artist");
        albumLabel = new javax.swing.JLabel("Album");
        titleLabel.setBounds(50, 10, 100, 20);
        artistLabel.setBounds(50, 50, 100, 20);
        albumLabel.setBounds(50, 90, 100, 20);
        add(titleLabel);
        add(artistLabel);
        add(albumLabel);
        
        titleTextField = new javax.swing.JTextField();
        titleTextField.setFont(font);
        artistTextField = new javax.swing.JTextField();
        artistTextField.setFont(font);
        albumTextField = new javax.swing.JTextField();
        albumTextField.setFont(font);
        titleTextField.setBounds(120, 10, 200, 20);
        artistTextField.setBounds(120, 50, 200, 20);
        albumTextField.setBounds(120, 90, 200, 20);
        add(titleTextField);
        add(artistTextField);
        add(albumTextField);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);        
       setBounds(500, 300, 400, 370);
       setMaximumSize(new Dimension(420, 430));
        setMinimumSize(new Dimension(420, 430));
        setFocusCycleRoot(false);
        getContentPane().setLayout(null);        
       
       t.setColumnSelectionAllowed(true);
       sp.setViewportView(t);
       t.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(sp);
     sp.setBounds(0, 130, 400, 190);

     b.setBackground(new Color(0, 151, 55));
     b.setFont(new Font("Calibri", 0, 16));
     b.setForeground(new Color(255, 255, 255));
     b.setText("Search!");
      getContentPane().add(b);
      b.setBounds(140, 330, 111, 40);
      b.addActionListener(this);
      pack();
   t.addMouseListener(this);
 this.setVisible(true);

     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
           }
        }catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 } 
@Override
    public void actionPerformed(ActionEvent e) {
       
       
       try{
                Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/lyrics?useUnicode=true&characterEncoding=utf8","root","");
       sta=con.createStatement();
       t.setModel(new DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                   "Title", "Artist", "Album"
               }
           ));
       rs=sta.executeQuery("select * from lyrics where title like '%"+titleTextField.getText()+"%' and album like '%"+albumTextField.getText()+"%' and artist like '%"+artistTextField.getText()+"%'");
     t.setEditingColumn(0);
     t.setEditingRow(0);
     
       t.removeAll();   	   model=(DefaultTableModel)t.getModel();
     
     						for(int i=0;i<model.getRowCount();i++)
     						{
     							model.removeRow(i);
     						}
     
                        while(rs.next()){
                          d1=rs.getString("title");
                          d2=rs.getString("artist");
                          d3=rs.getString("album");
                          model.addRow(new Object[]{d1,d2,d3});
                       
                        }
                      
                        
                        rs.close();
                        sta.close();
                        //con.close();
                        //JOptionPane.showMessageDialog(this,"working !");
       } 
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
       }
    } 
JTable ta;int row=0,col=0;
static String lyr="";
@Override
public void mouseClicked(MouseEvent e) {
	//System.out.print(e.getClickCount());
	 ta = ( (JTable) e.getSource());
	
	if (e.getClickCount() == 1) {
		
		 row = ta.getSelectedRow();
		 col = ta.getSelectedColumn();
		
			
		}
	String v="";
	try{
	sta = con.createStatement();
	  rs=sta.executeQuery("select * from lyrics where title like '%"+ta.getValueAt(row,0).toString()+"%' and album like '%"+albumTextField.getText()+"%' and artist like '%"+artistTextField.getText()+"%'");
	 rs.next();
	 
	v = rs.getString("lyrics");
	
	}
	catch(Exception ex){System.out.print("vp"+ex.getMessage());}
	
	 //viewerDriver.jt.setText(v);
	StringBuffer fileContent = new StringBuffer();
	String str="";
	for (int i = 0; i < ta.getColumnCount(); i++) {
		 
		Object cellValue = i +""+ ta.getValueAt(row,i)+":" ;
		// ... continue to read each cell in a row
		
		str = str +  i +""+ ta.getValueAt(row,i)+":" ;
		
		
		//lyr =str;
		fileContent.append(cellValue);
		// ... continue to append each cell value
	}
	    
	try{
		
		
		fn = "c:\\Lyrics\\"+String.valueOf(ta.getValueAt(row, 0))+".lrc";
		//String fn = "c:\\Lyrics\\"+String.valueOf(v)+".lrc";
		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn), "UTF-8"));
	//FileWriter fileWriter = new FileWriter(new File(fn));
	//fileWriter.write(fileContent.toString()); 
	fileWriter.write(v); 
	fileWriter.flush();
	fileWriter.close();
	
	}
	catch(Exception ex)
	{}
	
	
try{
	//
	BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fn),"UTF-8"));		
	int ch;
	lyrics="";
	
	while((ch = fileReader.read())!=-1)
	{
		
			lyrics+=String.valueOf((char)ch);			
					
	}
	viewerDriver.jt.setText("");
    viewerDriver.jt.setText(lyrics);


	}
	catch(Exception ex)
	{}


	
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
@Override
public void caretPositionChanged(InputMethodEvent event) {
	// TODO Auto-generated method stub
	
}
@Override
public void inputMethodTextChanged(InputMethodEvent event) {
	// TODO Auto-generated method stub
	
	try {
		System.out.print(rs.getString("title"));
		
		} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}


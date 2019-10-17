import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.math.*;
import java.io.*;
	
class Notepad implements ActionListener,WindowListener,MouseMotionListener,KeyListener
{
	JFrame jf;float x,y;
	JTextArea jt;
	JTextArea jt1;
	JScrollPane jp;
	JMenuBar jb;JMenu file,edit,format,view,about,font;
	JMenuItem new1,open,save,saveAs,cut,copy,paste,help,selectAll,font1,font2;
	JFileChooser jc;
	Notepad()
	{
		jf =new JFrame("Notepad");
		jt =new JTextArea();
		jt1 =new JTextArea();
		jp =new JScrollPane(jt);
		jc =new JFileChooser();

		jb =new JMenuBar();

		jf.addWindowListener(this);
		jt.addMouseMotionListener(this);
		jt.addKeyListener(this);

		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		view = new JMenu("View");
		about =new JMenu("About");
		font =new JMenu("Font");

		new1 = new JMenuItem("New");
		save = new JMenuItem("Save");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		saveAs =new JMenuItem("Save As");
		open= new JMenuItem("Open");	
		help =new JMenuItem("Help");
		selectAll =new JMenuItem("Select All");
		paste.setEnabled(false);

		font1 = new JMenuItem("Times New Roman");
		font2 = new JMenuItem("Arial");

		jf.setLayout(new BorderLayout());
		jf.add(jt1,BorderLayout.SOUTH);

		jf.add(jp);
		jt1.setEnabled(false);
		//jf.add(jt1);
	
		file.add(new1);
		file.add(save);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		format.add(font);
		about.add(help);
		file.add(open);
		file.add(saveAs);
		edit.add(selectAll);

		jb.add(file);
		jb.add(edit);
		jb.add(format);
		jb.add(view);
		jb.add(about);

		font.add(font1);
		font.add(font2);

		Font f =new Font("Times New Roman ", Font.BOLD, 20);
		jt.setFont(f);

		new1.addActionListener(this);
		save.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		font.addActionListener(this);
		help.addActionListener(this);
		open.addActionListener(this);
		saveAs.addActionListener(this);
		selectAll.addActionListener(this);
		font1.addActionListener(this);
		font2.addActionListener(this);

		jf.setJMenuBar(jb);
		jf.setSize(600,600);
		jf.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() =="New")
			{
				jt.setText("");
			}
		else if(ae.getActionCommand()=="Open")
		{
			jc.showOpenDialog(jf);
			try
			{
				String data="";
				FileInputStream fin =new FileInputStream(jc.getSelectedFile());
				int k;
				while((k=(int)fin.read())!=-1)
				{
					data =data+(char)k;
				}
				jt.setText(data);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}
		else if(ae.getActionCommand() == "Save")
		{
			try
			{
				FileOutputStream f =new FileOutputStream("Test.txt");
				String data;
				data=jt.getText();	
				byte b[]=data.getBytes();
				f.write(b);
				f.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else if(ae.getActionCommand()=="Save As")
		{
			//System.out.println(ae.getActionCommand());
			jc.showSaveDialog(jf);
			try
			{
				FileOutputStream fout =new FileOutputStream(jc.getSelectedFile());
				String data = jt.getText();
				byte b[]=data.getBytes();
				fout.write(b);
				fout.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}
		else if(ae.getActionCommand()=="Times New Roman")
		{
			Font f =new Font("Times New Roman ", Font.BOLD, 20);
			jt.setFont(f);
		}
		else if(ae.getActionCommand()=="Arial")
		{
			Font f =new Font("Times New Roman ", Font.ITALIC, 20);
			jt.setFont(f);
		}
		else if(ae.getActionCommand()=="Copy")
		{
			jt.copy();
			paste.setEnabled(true);
		}
		else if(ae.getActionCommand()=="Cut")
		{
			jt.cut();
			paste.setEnabled(true);
		}
		else if(ae.getActionCommand()=="Paste")
		{

			jt.paste();
		}
		else if(ae.getActionCommand()=="Select All")
		{
			jt.selectAll();
		}
		else if(ae.getActionCommand()=="Help")
		{
			JOptionPane.showMessageDialog(jf,"Help is Provided soon...:)");
		}		
	}
	
	public void windowOpened(WindowEvent we)
	{
		
	}
	public void windowClosed(WindowEvent we)
	{
		
	}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowIconified(WindowEvent we)
	{
		
	}
	public void windowDeiconified(WindowEvent we)
	{
		
	}
	public void windowDeactivated(WindowEvent we)
	{
		
	}
	public void windowActivated(WindowEvent we)
	{
		
	}

	public void mouseMoved(MouseEvent me)
	{
		Font f =new Font("Times New Roman", Font.BOLD, 10);
		jt1.setFont(f);
		jt1.setText("x :"+me.getX() +" y :"+me.getY());
	}
	public void mouseDragged(MouseEvent me)
	{
		Font f =new Font("Times New Roman", Font.BOLD, 10);
		jt1.setFont(f);
		jt1.setText("x :"+me.getX() +" y :"+me.getY());
	}
	public void keyPressed(KeyEvent ke)
	{

	}
	public void keyTyped(KeyEvent ke)
	{
		
	}
	public void keyReleased(KeyEvent ke)	
	{
		String s = jt.getText();
		String w[] = s.split("\\s+");
		String l[] = s.split("\n");
		// String t[] = s.split("\t");
		 int words=w.length; 
		 int lines =l.length;
		jt1.setText(" Words : "+ (words)+" Lines : "+lines);
	}
	
	
	public static void main(String args[])throws Exception
	{
		Notepad n = new Notepad();
		
	}
		
	
}
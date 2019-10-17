import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.math.*;
import java.io.*;
	
class Note 
{
	JFrame jf;
	JTextArea jt;
	JScrollPane jp;
	JMenuBar jb;JMenu file,edit,format,view,about;
	JMenuItem new1,open,save,saveAs,cut,copy,paste,font,help;
	//JFileChooser jc;
	Note()
	{
		jf =new JFrame("Notepad");
		jt =new JTextArea();
		jp =new JScrollPane(jt);
		//jc =new JFileChooser();

		jb =new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		view = new JMenu("View");
		about =new JMenu("About");

		new1 = new JMenuItem("New");
		save = new JMenuItem("Save");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		font = new JMenuItem("Font");
		saveAs =new JMenuItem("Save As");
		open= new JMenuItem("Open");	


		
	
		file.add(new1);
		file.add(save);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		format.add(font);
		//about.add(help);
		file.add(open);

		jb.add(file);
		jb.add(edit);
		jb.add(format);
		jb.add(view);
		jb.add(about);

		
		
		jf.add(jp);
		jf.setJMenuBar(jb);
		jf.setSize(600,600);
		jf.setVisible(true);

	}
	public static void main(String args[])
		{
			Note t =new Note();
		}
}


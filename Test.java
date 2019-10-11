import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Test extends JFrame implements ActionListener
{
	JTextArea tf;JScrollPane jp;
	JMenuBar mb;
	JMenu file,edit,format,view,help;
	JMenuItem new1,save,copy,cut,paste,selectAll;
	
	Test()
	{
		mb=new JMenuBar();
		tf =new JTextArea();
		jp = new JScrollPane(tf);
		file = new JMenu("File");
		edit= new JMenu("Edit");
		format = new JMenu("Format");
		view= new JMenu("View");
		help = new JMenu("Help");

		add(jp);	
	
		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(view);
		mb.add(help);

		new1 = new JMenuItem("New");
		save = new JMenuItem("Save");
		copy = new JMenuItem("Copy");
		cut = new JMenuItem("Cut");
		paste = new JMenuItem("Paste");
		selectAll = new JMenuItem("Select All");
		
		paste.setEnabled(false);		

		new1.addActionListener(this);
		//save.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		

		file.add(new1);
		file.add(save);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);	
	
		setJMenuBar(mb);
		setSize(500,500);
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==new1)
		{
			tf.setText("");	
		}
		else if(ae.getSource()==copy)
		{
			tf.copy();
			paste.setEnabled(true);	
		}
		else if(ae.getSource()==cut)
		{
			tf.cut();
			paste.setEnabled(true);	
		}
		else if(ae.getSource()==paste)
		{
			tf.paste();	
		}
		else if(ae.getSource()==selectAll)
		{
			tf.selectAll();	
		}
		
	}
	public static void main(String args[])
	{
		Test t =new Test();
	}
}
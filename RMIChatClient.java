package assignment.chat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class RMIChatClient extends JFrame implements ChatClientInterface,ActionListener
{
	Container c;
	JTextArea jta;
	JList list;
	JTextField jtf;
	JButton jbtn;
	JScrollPane jsp1,jsp2;
	DefaultListModel model;
	String key = "rmi://localhost:1099/mikado";
	ChatServerInterface csi;
	String myName;
	 public RMIChatClient(String name)
	{
		 super("Chat Client "+name);
		 myName = name;
		 setResizable(false);
		 setSize(720,475);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 c = getContentPane();
		 c.setLayout(null);

		 jta = new JTextArea();
		 jsp1 = new JScrollPane(jta);
		 jsp1.setBounds(5,5,500,400);
		 c.add(jsp1);

		 model =  new DefaultListModel();

		 list = new JList(model);
		 jsp2 = new JScrollPane(list);
		 jsp2.setBounds(510,5,200,400);
		 c.add(jsp2);

		 jtf = new JTextField();
		 jtf.setBounds(5,410,500,25);
		 c.add(jtf);

		  jbtn = new JButton("Send");
		 jbtn.setBounds(510,410,200,25);
		 c.add(jbtn);
		 jtf.addActionListener(this);
		 jbtn.addActionListener(this);

		 addWindowListener(new WindowAdapter()
		{
			 public void windowClosing(WindowEvent e)
			{
				 try
				{
					 csi.logout(myName);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		 });
			 try
			 {
				csi = (ChatServerInterface)Naming.lookup(key);
				 UnicastRemoteObject.exportObject(this);
				 csi.login(myName,this);
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 jta.setEditable(false);
			 setVisible(true);
	}
	public void takeMsg(String msg)
	{
		jta.append(msg+"\n");
	}
	public void takeClientList(final Vector<String> Clients)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				model.removeAllElements();
				Enumeration<String> en = Clients.elements();
				while(en.hasMoreElements())
				{
					String s = en.nextElement();
					model.addElement(s);
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		String msg = jtf.getText();
		msg = myName+" : "+msg;
		try
		{
			csi.takeMsg(msg);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		jtf.setText(" ");
	}
	public static void main(String args[])
	{
		RMIChatClient app = new RMIChatClient(args[0]);
	}
};
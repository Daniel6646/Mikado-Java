package assignment.chat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class RMIChatClient1 extends JFrame implements ChatClientInterface1,ActionListener
{
	Container c;
	JTextArea jta;
	JList list;
	JTextField jtf;
	JButton jbtn;
	JScrollPane jsp1,jsp2;
	DefaultListModel model;
	String key = "rmi://localhost:1099/mikado";
	ChatServerInterface1 csi;
	String myName;
	Hashtable<String,MiniWindow>  ht;
	 public RMIChatClient1(String name)
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
		 
		 ht = new Hashtable<String,MiniWindow> ();
		 list.addMouseListener (new MouseAdapter()
		{
			 @Override
				 public void mouseClicked(MouseEvent e)
				{
				 if(e.getClickCount() == 2)
					{
					 String hisName = (String)list.getSelectedValue();
					 MiniWindow mw = ht.get(hisName);
					 if(mw == null)
						{
						 try
							{
							 ChatClientInterface1 hisRef = csi.giveRef(hisName);
							 mw = new MiniWindow (hisName,hisRef);
							 ht.put(hisName,mw);
							}
							catch(Exception e1)
							{
								System.out.println(e1);
							}
						}
					}
				}						
		});
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
				csi = (ChatServerInterface1)Naming.lookup(key);
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
	public void pm(String hisName,ChatClientInterface1 hisRef,String hisMsg)
	{
		MiniWindow mw = ht.get(hisName);
		if(mw == null)
		{
			mw = new MiniWindow(hisName,hisRef);
			ht.put(hisName,mw);
		}
		mw.jta.append(hisMsg+"\n");
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
	public class MiniWindow extends JFrame implements ActionListener
	{
		Container c;
		JTextArea jta;
		JTextField jtf;
		JButton jbtn;
		JScrollPane jsp;
		String hisName;
		ChatClientInterface1 hisRef;
		public MiniWindow(String name, ChatClientInterface1 ref)
		{
				super("From "+myName+" to "+name);
				hisName = name;
				hisRef = ref;
				setResizable(false);
				setSize(340,280);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				c = getContentPane();
				c.setLayout(null);

				jta = new JTextArea();
				jsp = new JScrollPane(jta);
				jsp.setBounds(5,5,325,200);
				c.add(jsp);

				 jtf = new JTextField();
				 jtf.setBounds(5,210,235,25);
				 c.add(jtf);

				  jbtn = new JButton("Send");
				 jbtn.setBounds(245,210,85,25);
				 c.add(jbtn);

				 addWindowListener(new WindowAdapter()
				{
					 public void windowClosing(WindowEvent e)
					{
						ht.remove(hisName);
					}
				 });
				 jtf.addActionListener(this);
				 jbtn.addActionListener(this);
				 jta.setEditable(false);
				 setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			String myMsg = jtf.getText();
			myMsg = myName+" : "+myMsg;
			try
			{
				hisRef.pm(myName,RMIChatClient1.this,myMsg);
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			jta.append(myMsg+"\n");
			jtf.setText(" ");
		}
	}
	public static void main(String args[])
	{
		RMIChatClient1 app = new RMIChatClient1(args[0]);
	}
};
package assignment.sockets;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 public class ChatGUIClient extends JFrame implements ActionListener
 {
	 DataInputStream dis,local;
	  PrintStream ps;
	  static String ClientName;
	  Container c;
	  JTextArea jta;
	  JTextField jtf;
	 JButton jbtn;
	 JScrollPane jsp,jsp1;
	 public ChatGUIClient(String name)
	 {
		 super("Chat Client :"+name);
		 ClientName = name;
		 setSize(500,500);
		 setResizable(false);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 c=getContentPane();
		 c.setLayout(null);
		 jta = new JTextArea(20,50);
		 jsp = new JScrollPane(jta);
		 jsp.setBounds(30,40,440,300);
		 c.add(jsp);
		 jtf = new JTextField();
		 jsp1 = new JScrollPane(jtf);
		 jsp1.setBounds(30,360,340,70);
		 c.add(jsp1);
		 jbtn = new JButton("SEND");
		 jbtn.setBounds(380,360,90,70);
		 c.add(jbtn);
		 jbtn.addActionListener(this);
		 jtf.addActionListener(this);
		 try
		 {
			 Socket server=new Socket("localhost",10000);
			 dis=new DataInputStream(server.getInputStream());
			 ps=new PrintStream(server.getOutputStream());
			 Type2Thread type2=new Type2Thread();
			 type2.start();
		 }
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 jta.setEditable(false);
		 setVisible(true);
	 }
	 public class Type2Thread extends Thread
	 {
		 public void run()
		 {
			 while (true)
			 {
				 try
				 {
					 String msg=dis.readLine();
					 jta.append("\n"+msg);
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
				 }
			 }
		 }
	 };
	 public void actionPerformed(ActionEvent e)
	 {
		 String msg=jtf.getText();
		 ps.println(ClientName+": "+msg);
		 jtf.setText("");
	 }
		 public static void main(String args[])
	 {
			 new ChatGUIClient(args[0]);
	 }
 };
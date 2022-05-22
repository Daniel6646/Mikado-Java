package assignment.jdbc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class JdbcPrepareGUI extends JFrame
{
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jbtn;
	JLabel jb1,jb2,jb3,jb4;
	Container c;
	Connection con;
	PreparedStatement pstmt;
	public JdbcPrepareGUI()
	{
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
		jb1 =new JLabel("Id");
		jb1.setBounds(10,10,100,30);
		c.add(jb1);

		jtf1 =new JTextField();
		jtf1.setBounds(120,10,150,30);
		c.add(jtf1);

		jb2 =new JLabel("Name");
		jb2.setBounds(10,50,100,30);
		c.add(jb2);

		jtf2 =new JTextField();
		jtf2.setBounds(120,50,150,30);
		c.add(jtf2);

		jb3 =new JLabel("Salary");
		jb3.setBounds(10,90,100,30);
		c.add(jb3);

		jtf3 =new JTextField();
		jtf3.setBounds(120,90,150,30);
		c.add(jtf3);

		jbtn =new JButton("Submit");
		jbtn.setBounds(50,130,100,30);
		c.add(jbtn);

		jb4 =new JLabel("Row Affected");
		jb4.setBounds(10,170,100,30);
		c.add(jb4);

		jtf4 =new JTextField();
		jtf4.setBounds(120,170,150,30);
		c.add(jtf4);
		try
		{
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mikado");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("Insert into employee values(?,?,?)");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			jbtn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					try
					{
							pstmt.setInt(1,Integer.parseInt(jtf1.getText()));
							pstmt.setString(2,jtf2.getText());
							pstmt.setDouble(3,Double.parseDouble(jtf3.getText()));
							int i = pstmt.executeUpdate();
							con.commit();
							//con.rollback();
							jtf4.setText(String.valueOf(i));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			});
			addWindowListener(new WindowAdapter()
			{
				public void WindowClosing(WindowEvent we)
				{
					try
					{
						pstmt.close();
						con.close();
					}
					catch(Exception e)
						{
							e.printStackTrace();
						}
				}
			});
			setVisible(true);
	}
	public static void main(String args[])
	{
		new JdbcPrepareGUI();
	}
};
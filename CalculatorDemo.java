package assignment.swings;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CalculatorDemo extends JFrame
{
	JButton plusBtn,minusBtn,mulBtn,divBtn,equalsBtn;
	JTextField num1TF,num2TF,resultTF;
	char sign='0';
	public CalculatorDemo(String title)
	{
		super(title);
		setLayout(null);
		setSize(240,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		num1TF = new JTextField();
		num1TF.setHorizontalAlignment(JTextField.RIGHT);
		num1TF.setBounds(5,5,215,30);
		add(num1TF);
		plusBtn = new JButton ("+");
		plusBtn.setBounds(5,40,50,30);
		add(plusBtn);
		minusBtn = new JButton("-");
		minusBtn.setBounds(60,40,50,30);
		add(minusBtn);
		mulBtn = new JButton("x");
		mulBtn.setBounds(115,40,50,30);
		add(mulBtn);
		divBtn = new JButton("/");
		divBtn.setBounds(170,40,50,30);
		add(divBtn);
		num2TF = new JTextField();
		num2TF.setHorizontalAlignment(JTextField.RIGHT);
		num2TF.setBounds(5,75,215,30);
		add(num2TF);
		equalsBtn =new JButton("=");
		equalsBtn.setBounds(90,110,50,30);
		add(equalsBtn);
		resultTF = new JTextField();
		resultTF.setHorizontalAlignment(JTextField.RIGHT);
		resultTF.setBounds(5,145,215,30);
		add(resultTF);
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				sign='+';
			}
		});
		minusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				sign='-';
			}
		});
		mulBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				sign='x';
			}
		});
		divBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				sign='/';
			}
		});
		equalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				double n1,n2,result=0;
				String s1=num1TF.getText();
				String s2=num2TF.getText();
				if(s1.equals("") || s2.equals("") || sign== '0')
				{
				if(s1.equals(""))
				{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(CalculatorDemo.this,"Enter 1st number","Error",JOptionPane.ERROR_MESSAGE);
					num1TF.requestFocus();
					return;
			}
			if(s2.equals(""))
				{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(CalculatorDemo.this,"Enter 2nd number","Error",JOptionPane.ERROR_MESSAGE);
					num2TF.requestFocus();
					return;
			}
			if(sign =='0')
				{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(CalculatorDemo.this,"Select an operation","Error",JOptionPane.ERROR_MESSAGE);
					num1TF.requestFocus();
					return;
			}
	}
	else
				{
		n1=Double.parseDouble(s1);
		n2=Double.parseDouble(s2);
		switch(sign)
					{
				case '+': result = n1+n2;break;
				case '-': result = n1-n2;break;
				case 'x': result = n1*n2;break;
				case '/': result = n1/n2;break;
					}
					resultTF.setText(String.valueOf(result));
					sign='0';
				}
			}
		});
		setVisible(true);
};
public static void main(String args[])
	{
	new CalculatorDemo("Calculator");
	}
}
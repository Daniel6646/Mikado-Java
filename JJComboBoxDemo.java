package assignment.swings;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JJComboBoxDemo extends JFrame
{
	DefaultComboBoxModel model1,model2;
	JComboBox continentsCB,countriesCB;
	JTextField capitalTf;

	String continents[] = {"Asia","Africa","North America"};
	String countries[][] = {{"India","China","Japan"},{"Egypt","Kenya","Nigeria"}, {"Canada","Mexico","USA"}};
	String capitals[][] = {{"Delhi","Beijing","Tokyo"},{"Cairo","Naiobi","Abuja"},{"Ottawa","Mexico City","Washington DC"}};
	boolean flag;
	int continentIndex,countryIndex;
	
	public JJComboBoxDemo(String title)
	{
		super(title);

		setLayout(null);
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		model1 = new DefaultComboBoxModel (continents);

		continentsCB = new JComboBox(model1);
		continentsCB.setBounds(10,10,100,30);
		add(continentsCB);
		
		model2 = new DefaultComboBoxModel (countries[0]); 

		countriesCB = new JComboBox(model2);
		countriesCB.setBounds(120,10,100,30);
		add(countriesCB);

		capitalTf = new JTextField();
		capitalTf.setBounds(230,10,100,30);
		capitalTf.setEditable(false);
		add(capitalTf);
		capitalTf.setText(capitals[0][0]);

		continentsCB.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				flag = true;
				continentIndex = continentsCB.getSelectedIndex();
				capitalTf.setText("");
				//countriesCB.removeAllItems();
				model2.removeAllElements();
				for(int i=0;i<countries[continentIndex].length;i++)
				{
					model2.addElement(countries[continentIndex][i]);
					//countriesCB.addItem(countries[continentIndex][i]);
				}
				capitalTf.setText(capitals[continentIndex][0]);
				flag = false;
			}
		});

		countriesCB.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(flag)
					return;

				countryIndex = countriesCB.getSelectedIndex();
				capitalTf.setText(capitals[continentIndex][countryIndex]);
			}
		});
		
		setVisible(true);
	}

	public static void main(String args[])
	{
		new JJComboBoxDemo("JComboBoxDemo");
	}
}
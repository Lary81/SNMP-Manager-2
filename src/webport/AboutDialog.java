package webport;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.applet.*;

public class AboutDialog extends JDialog implements Runnable
{

	private JLabel aboutLabel1 = new JLabel("Lee WebPort");
	private JLabel aboutLabel2 = new JLabel("Guillermo Villamayor");
	private JLabel aboutLabel3 = new JLabel("Diciembre, 2005");
	private JLabel aboutLabel4 = new JLabel("");
	private JLabel aboutLabel5 = new JLabel("");

	private String inquisitionString = "\"Nadie espera ser leido de esta forma...\" ";
	private String mpString = "   (- Este programa esta algo afanado pero no mucho)";

	Thread displayThread;


	public AboutDialog(JFrame parent)
	{
		super(parent, "Lee WebPort", true );

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setUpDisplay();

		this.setLocation(Math.round((parent.getSize().width - this.getSize().width)/2), Math.round((parent.getSize().height - this.getSize().height)/2));

	//	 create and start display thread
		displayThread = new Thread(this);
		displayThread.start();

		this.show();

	}




	public void hide()
	{
		super.hide();

		// interrupt thread so it can exit..
		displayThread.interrupt();
	}




	private void setUpDisplay()
	{

		// set params for layout manager
		GridBagLayout  theLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(2,2,2,2);
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.weighty = 0;

		JPanel aboutPanel = new JPanel();
		aboutPanel.setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		theLayout.setConstraints(aboutLabel1, c);
		aboutPanel.add(aboutLabel1);

		c.gridx = 1;
		c.gridy = 2;
		theLayout.setConstraints(aboutLabel2, c);
		aboutPanel.add(aboutLabel2);

		c.gridx = 1;
		c.gridy = 3;
		theLayout.setConstraints(aboutLabel3, c);
		aboutPanel.add(aboutLabel3);

		c.gridx = 1;
		c.gridy = 4;
		theLayout.setConstraints(aboutLabel4, c);
		aboutPanel.add(aboutLabel4);

		c.gridx = 1;
		c.gridy = 5;
		theLayout.setConstraints(aboutLabel5, c);
		aboutPanel.add(aboutLabel5);


		this.getContentPane().add(aboutPanel);
		this.pack();

		this.setSize(320, 150);

	}



	public void run()
	{


		try
		{
			int numChars = inquisitionString.length();

			for (int i = 0; i < numChars; i++)
			{
				aboutLabel4.setText(inquisitionString.substring(0,i));
				Thread.currentThread().sleep(60);
			}

			aboutLabel5.setText(mpString);

		}
		catch(Exception e)
		{
			System.out.println(e);
		}



	}



}
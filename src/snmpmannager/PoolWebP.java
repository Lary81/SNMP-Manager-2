import java.util.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import java.io.*;
import java.math.*;
import webport.*;




public class PoolWebP extends JFrame	implements ActionListener
{

	JButton leerButton;
	JTextArea messagesArea;
	JScrollPane messagesScroll;
	JTextField hostIDField ;
	JLabel communityLabel, authorLabel, hostIDLabel;

	MenuBar theMenubar;
	Menu fileMenu;
	MenuItem aboutItem, quitItem;

	// WindowCloseAdapter para cerrar el programa
	private class WindowCloseAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
		    System.exit(0);
		}
	};


	public PoolWebP()
	{
		setUpDisplay();


	}


// * * * * * * * * * * * * *
public void leer()
{

try
		{


							InetAddress hostAddress = InetAddress.getByName(hostIDField.getText());
							String community = "public";
							int version = 0;	// SNMPv1

							SNMPv1CommunicationInterface comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);


							String itemID = "1.3.6.1.4.1.12199.1.1.2.1.1.1.0";




				messagesArea.append("Temperaturas:\n\n");



							SNMPVarBindList newVars = comInterface.getMIBEntry(itemID);


							messagesArea.append ("Florenico Varela\n");
							SNMPSequence pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
							SNMPObject snmpValue = pair.getSNMPObjectAt(1);
							messagesArea.append ("Descripcion: " + snmpValue.toString()+"\n");
				//			salida.write(snmpValue.toString());





		}

		catch(Exception e)
		{
			messagesArea.append("Error durante la operacion SNMP:  " + e + "\n");
		}
}
// * * * * *




	private void setUpDisplay()
	{
		this.setTitle("Lee la configuraci�n de los WebPort");
		this.getRootPane().setBorder(new BevelBorder(BevelBorder.RAISED));

//* * * * * * E S T O   E S   P A R A   P O D E R   C E R R A R   L A   V E N T A N A
		addWindowListener(new WindowCloseAdapter());

		theMenubar = new MenuBar();
		this.setMenuBar(theMenubar);
		fileMenu = new Menu("Archivo");

		aboutItem = new MenuItem("Acerca...");
		aboutItem.setActionCommand("about");
		aboutItem.addActionListener(this);
		fileMenu.add(aboutItem);
		fileMenu.addSeparator();
		quitItem = new MenuItem("Salir");
		quitItem.setActionCommand("quit");
		quitItem.addActionListener(this);
		fileMenu.add(quitItem);
		theMenubar.add(fileMenu);

		hostIDLabel = new JLabel("IP del WebPort:");
		hostIDField = new JTextField(20);
		hostIDField.setText("10.5.76.72");
		hostIDField.setEditable(true);

		authorLabel = new JLabel(" Version 0.1        Guillermo Villamayor - Diciembre 2005 ");
		authorLabel.setFont(new Font("SansSerif", Font.ITALIC, 8));

		leerButton = new JButton("Leer Configuracion");
		leerButton.setActionCommand("leer");
		leerButton.addActionListener(this);

		messagesArea = new JTextArea(10,60);
		messagesScroll = new JScrollPane(messagesArea);


// * * * * * * * * * * * * P A N T A L L A * * * * * * * * * * * * * * * * * * * * * * * * *

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

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		theLayout.setConstraints(leerButton, c);
		buttonPanel.add(leerButton);

		JPanel hostPanel = new JPanel();
		hostPanel.setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		theLayout.setConstraints(hostIDLabel, c);
		hostPanel.add(hostIDLabel);

		c.gridx = 2;
		c.gridy = 1;
		theLayout.setConstraints(hostIDField, c);
		hostPanel.add(hostIDField);

		JPanel oidPanel = new JPanel();
		oidPanel.setLayout(theLayout);

		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;

		JPanel messagesPanel = new JPanel();
		messagesPanel.setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		JLabel messagesLabel = new JLabel("Configuracion:");
		theLayout.setConstraints(messagesLabel, c);
		messagesPanel.add(messagesLabel);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.weightx = .5;
		c.weighty = .5;
		c.anchor = GridBagConstraints.CENTER;
		theLayout.setConstraints(messagesScroll, c);
		messagesPanel.add(messagesScroll);

		c.gridwidth = 1;
		c.weightx = 0;
		c.weighty = 0;

		this.getContentPane().setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		theLayout.setConstraints(hostPanel, c);
		this.getContentPane().add(hostPanel);

		c.gridx = 1;
		c.gridy = 2;
		theLayout.setConstraints(oidPanel, c);
		this.getContentPane().add(oidPanel);

		c.gridx = 1;
		c.gridy = 3;
		theLayout.setConstraints(buttonPanel, c);
		this.getContentPane().add(buttonPanel);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = .5;
		c.weighty = .5;
		theLayout.setConstraints(messagesPanel, c);
		this.getContentPane().add(messagesPanel);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 0;
		c.weighty = 0;
		theLayout.setConstraints(authorLabel, c);
		this.getContentPane().add(authorLabel);


	}





	public void actionPerformed(ActionEvent theEvent)
	// respond to button pushes, menu selections
	{
		String command = theEvent.getActionCommand();

		if (command == "quit")
		{
			System.exit(0);
		}

		if (command == "about")
		{
			AboutDialog aboutDialog = new AboutDialog(this);
		}



		}



	public static void main(String args[])
	{
		try
		{
			PoolWebP theApp = new PoolWebP();
			theApp.pack();
			theApp.setSize(600,500);
			theApp.show();
			theApp.leer();
		}
		catch (Exception e)
		{}



}


}
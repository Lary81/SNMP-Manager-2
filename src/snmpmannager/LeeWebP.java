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




public class LeeWebP extends JFrame	implements ActionListener
{

	JButton leerButton;
	JTextArea messagesArea;
	JScrollPane messagesScroll;
	JTextField hostIDField ;
	JLabel communityLabel, authorLabel;

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


	public LeeWebP()
	{
		setUpDisplay();


	}


// * * * * * * * * * * * * *
public void leer()
{

try
		{
			String community = "public";
			int version = 0;	// SNMPv1
//					messagesArea.setFont (new Font("SansSerif", Font.ITALIC, 14));
messagesArea.setBackground(Color.BLACK);
messagesArea.setForeground(Color.GREEN);
			messagesArea.append("WebPort		Red	Bateria\n\n");
	//		messagesArea.setForeground(Color.BLACK);

				InetAddress hostAddress = InetAddress.getByName("10.5.76.72");
				SNMPv1CommunicationInterface comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				String itemID = "1.3.6.1.2.1.1.6.0";
				SNMPVarBindList newVars = comInterface.getMIBEntry(itemID);
				SNMPSequence pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				SNMPObject snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				int i = Integer.parseInt(snmpValue.toString());
	//			messagesArea.append (snmpValue.toString()+"	");
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.118.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
	//			messagesArea.append (snmpValue.toString()+"	");
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.112.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
	//			messagesArea.append (snmpValue.toString()+"	");
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.114.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
		//		messagesArea.append (snmpValue.toString()+"	");
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.198.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
//				messagesArea.append (snmpValue.toString()+"	");
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.116.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.86.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.58.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.196.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.194.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.5.60.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");

				hostAddress = InetAddress.getByName("10.44.6.72");
				comInterface = new SNMPv1CommunicationInterface(version, hostAddress, community);
				itemID = "1.3.6.1.2.1.1.6.0";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				messagesArea.append (snmpValue.toString()+"		");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.1";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"	");
				itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.2.1.17.2";
				newVars = comInterface.getMIBEntry(itemID);
				pair = (SNMPSequence)(newVars.getSNMPObjectAt(0));
				snmpValue = pair.getSNMPObjectAt(1);
				i = Integer.parseInt(snmpValue.toString());
				messagesArea.append (i/10+"\n");




		}

		catch(Exception e)
		{
			messagesArea.append("El Webport no responde\n");
		}
}
// * * * * *




	private void setUpDisplay()
	{
		this.setTitle("Estado general de los Webport");
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


		authorLabel = new JLabel(" Version 0.1        Guillermo Villamayor - Mayo 2006 ");
		authorLabel.setFont(new Font("SansSerif", Font.ITALIC, 8));

		leerButton = new JButton("Leer Configuraci�n");
		leerButton.setActionCommand("leer");
		leerButton.addActionListener(this);

		messagesArea = new JTextArea(10,60);
		messagesArea.setEditable(false);
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


		JPanel oidPanel = new JPanel();
		oidPanel.setLayout(theLayout);

		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;

		JPanel messagesPanel = new JPanel();
		messagesPanel.setLayout(theLayout);

		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		JLabel messagesLabel = new JLabel("WebPorts vivos:");
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
			LeeWebP theApp = new LeeWebP();
			theApp.pack();
			theApp.setSize(600,500);
			theApp.show();
			theApp.leer();
		}
		catch (Exception e)
		{}



}


}
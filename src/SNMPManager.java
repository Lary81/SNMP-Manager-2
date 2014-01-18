import webport.*;
import java.util.*;
import java.math.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.event.*;









public class SNMPManager extends JFrame implements ActionListener
{
	SNMPv1CommunicationInterface readInterface, writInterface;
	SNMPVarBindList newVars;


	JButton leerButton;
	JTextArea messagesArea;
	JScrollPane messagesScroll;
	JTextField hostIDField ;
	JLabel communityLabel, authorLabel, hostIDLabel;

	MenuBar theMenubar;
	Menu fileMenu;
	MenuItem aboutItem, quitItem;
	WPArch WP2;
	WebPort WP3;
	String itemID = new String();



	// WindowCloseAdapter para cerrar el programa
	private class WindowCloseAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
		    System.exit(0);
		}
	};








	public SNMPManager()
	{
			WP3 = new WebPort();
			WP2 = new WPArch(WP3);
			setUpDisplay();
			WP2.leer();
		for (int i=0;i<82;i++)
		{
			messagesArea.append(WP3.getVariable(i)+"	"+WP3.getNomVar(i)+"		"+WP3.getValor(i)+"		"+WP3.getOIDPrinc()+"."+WP3.getObjectID(i)+"\n");
		}
		try
		{

			String readComm = "public";
			String writComm = "private";
			int version = 0;	// SNMPv1;

			InetAddress hostAddress = InetAddress.getByName("10.5.76.100");
			readInterface = new SNMPv1CommunicationInterface(version, hostAddress, readComm);
			writInterface = new SNMPv1CommunicationInterface(version, hostAddress, writComm);
		}
		catch(IOException e){System.out.println(e.getMessage());}
	}






	private void setUpDisplay()
	{
		this.setTitle("Graba la configuraci�n en un WebPort");
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
		hostIDField.setText("10.5.76.100");
		hostIDField.setEditable(true);

		authorLabel = new JLabel(" Version 0.1        Guillermo Villamayor - Diciembre 2005 ");
		authorLabel.setFont(new Font("SansSerif", Font.ITALIC, 8));

		leerButton = new JButton("Grabar Configuraci�n");
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
		JLabel messagesLabel = new JLabel("Configuraci�n:");
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
		messagesArea.append ("Archivo: WebPort.dat\n\n");
	//	for (int i=0;i<42;i++){messagesArea.append(WP3.getVariable(i)+"	"+WP3.getNomVar(i)+"			"+WP3.getOIDPrinc()+"."+WP3.getObjectID(i)+"\n");}


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


public String getItem(int n)
{
	String Item = new String();
	Item = WP3.getOIDPrinc()+"."+WP3.getObjectID(n);
	return Item;
}
















public void grabar()
{

for (int i=0;i<82;i++)
		{
			itemID = WP3.getOIDPrinc()+"."+WP3.getObjectID(i);
		}
	}
















	public static void main(String args[])
	{






		try
		{
                    SNMPManager WP1 = new SNMPManager();
			WP1.pack();
			WP1.setSize(600,500);
			WP1.show();
			WebPort WP5 = new WebPort();
			WP5=WP1.WP3;


//Lee el valor anterior
			for (int n=0;n<81;n++)
			{
//			String itemID = "1.3.6.1.4.1.12199.1.1.2.2.3.1.1.7.1";

			String itemID = WP1.getItem(n);
			WP1.newVars = WP1.readInterface.getMIBEntry(itemID);
			System.out.println(WP1.newVars);
			}



//Graba el valor nuevo
 switch (Integer.parseInt(WP5.getTipoDato(0).substring(0)))
  {
  	case  0:
      	SNMPInteger newValue = new SNMPInteger(Integer.parseInt(WP5.getValor(0)));
		System.out.println("Grabando el valor correspondiente al OID " + WP5.getObjectID(43));
	  	System.out.println("Nuevo valor: " + newValue.toString());
		WP1.newVars = WP1.writInterface.setMIBEntry(WP5.getOIDPrinc ()+"."+WP5.getObjectID(43), newValue);
    break;
  }
/*


	*/	}



		catch(Exception e)
		{
			System.out.println("Error en la operacion SNMP:  " + e.getMessage() + "\n");
		}

	}

}
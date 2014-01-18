package webport;


import java.util.*;
import java.io.*;


/** 
*	Class to hold IP addresses; special case of SNMP Octet String.
*/


public class SNMPIPAddress extends SNMPOctetString
{
	// length limited to 4 octets
	
	
	/** 
	*	Initialize to 0.0.0.0
	*/
		
	public SNMPIPAddress()
	{
		// initialize to 0.0.0.0
		tag = SNMPBERCodec.SNMPIPADDRESS;
		data = new byte[4];
		for (int i = 0; i < 4; i++)
			data[i] = 0;
	}
	
	
	/** 
	*	Used to initialize from a string containing a standard "dotted" IP address.
	* 	@throws SNMPBadValueException Indicates an invalid string supplied: more than 4 components,
	*	component values not between 0 and 255, etc.
	*/
	
	public SNMPIPAddress(String string)
		throws SNMPBadValueException
	{
		tag = SNMPBERCodec.SNMPIPADDRESS;
		this.data = parseIPAddress(string);
	}
	
	
	
	
	
	/** 
	*	Used to initialize from the BER encoding, as received in a response from 
	* 	an SNMP device responding to an SNMPGetRequest, or from a supplied byte array
	*	containing the address components.
	* 	@throws SNMPBadValueException Indicates an invalid array supplied: must have length 4.
	*/
	
	public SNMPIPAddress(byte[] enc)
		throws SNMPBadValueException
	{
		
		tag = SNMPBERCodec.SNMPIPADDRESS;
		
		if (enc.length == 4)
		{
			data = enc;
		}
		else		// wrong size
		{
			throw new SNMPBadValueException(" IPAddress: bad BER encoding supplied to set value ");
		}
	}
	
	
	
	
	
	/** 
	*	Used to set the value from a byte array containing the address.
	* 	@throws SNMPBadValueException Indicates an incorrect object type supplied, or array of
	*	incorrect size.
	*/
	
	public void setValue(Object newAddress)
		throws SNMPBadValueException
	{
		if ((newAddress instanceof byte[]) && (((byte[])newAddress).length == 4))
			data = (byte[])newAddress;
		else if (newAddress instanceof String)
		{
			data = parseIPAddress((String)newAddress);
		}
		else
			throw new SNMPBadValueException(" IPAddress: bad data supplied to set value ");
	}
	
	
	
	/** 
	* 	Return pretty-printed IP address.
	*/
	
	public String toString()
	{
		String returnString = new String();
		
		if (data.length > 0)
		{
			int convert = data[0];
			if (convert < 0)
					convert += 256;
				returnString += convert;
					
			for (int i = 1; i < data.length; i++)
			{
				convert = data[i];
				if (convert < 0)
					convert += 256;
				returnString += "." + convert;
			}
		}
		
		return returnString;
	}
	
	
	
	
	private byte[] parseIPAddress(String addressString)
		throws SNMPBadValueException
	{
		try
		{
			StringTokenizer st = new StringTokenizer(addressString, " .");
			int size = 0;
			
			while (st.hasMoreTokens())
			{
				// figure out how many values are in string
				size++;
				st.nextToken();
			}
			
			if (size != 4)
			{
				throw new SNMPBadValueException(" IPAddress: wrong number of components supplied to set value ");
			}
			
			byte[] returnBytes = new byte[size];
			
			st = new StringTokenizer(addressString, " .");
			
			for (int i = 0; i < size; i++)
			{
				int addressComponent = (Integer.parseInt(st.nextToken()));
				if ((addressComponent < 0) || (addressComponent > 255))
					throw new SNMPBadValueException(" IPAddress: invalid component supplied to set value ");
				returnBytes[i] = (byte)addressComponent;
			}
			
			return returnBytes;
			
		}
		catch (NumberFormatException e)
		{
			throw new SNMPBadValueException(" IPAddress: invalid component supplied to set value ");
		}
		
	}
	
	
	
	
}
package webport;

import java.util.*;
import java.io.*;


/**
*	Class representing a general string of octets.
*/

public class SNMPOctetString extends SNMPObject
{
	protected byte[] data;
	protected byte tag = SNMPBERCodec.SNMPOCTETSTRING;
		
	
	/**
	*	Create a zero-length octet string.
	*/
	
	public SNMPOctetString()
	{
		data = new byte[0];
	}
	
	
	/**
	*	Create an octet string from the bytes of the supplied String.
	*/
	
	public SNMPOctetString(String stringData)
	{
		this.data = stringData.getBytes();
	}
	
	
	
	
	/**
	*	Create an octet string from the supplied byte array. The array may be either
	*	user-supplied, or part of a retrieved BER encoding. Note that the BER encoding
	*	of the data of an octet string is just the raw bytes.
	*/
	
	public SNMPOctetString(byte[] enc)
	{
		extractFromBEREncoding(enc);
	}
	
	
	
	
	/**
	*	Return the array of raw bytes.
	*/
	
	public Object getValue()
	{
		return data;
	}
	
	
	
	
	/** 
	*	Used to set the value from a byte array.
	* 	@throws SNMPBadValueException Indicates an incorrect object type supplied.
	*/
	
	public void setValue(Object data)
		throws SNMPBadValueException
	{
		if (data instanceof byte[])
			this.data = (byte[])data;
		else if (data instanceof String)
			this.data = ((String)data).getBytes();
		else
			throw new SNMPBadValueException(" Octet String: bad object supplied to set value ");
	}
	
	
	
	
	
	/** 
	*	Returns the BER encoding for the octet string. Note the the "value" part of the
	*	BER type,length,value triple is just the sequence of raw bytes.
	*/
	
	protected byte[] getBEREncoding()
	{
		
		ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
		
		// calculate encoding for length of data
		byte[] len = SNMPBERCodec.encodeLength(data.length);
		
		// encode T,L,V info
		outBytes.write(tag);
		outBytes.write(len, 0, len.length);
		outBytes.write(data, 0, data.length);
	
		return outBytes.toByteArray();
	}
	
	
	
	
	protected void extractFromBEREncoding(byte[] enc)
	{
		data = new byte[enc.length];
		
		// copy data
		for (int i = 0; i < enc.length; i++)
		{
			data[i] = enc[i];
		}
	}
	
	
	
	
	
	/** 
	*	Returns a String constructed from the raw bytes. If the bytes contain non-printable
	*	ASCII characters, tant pis! (Though it's fun when the bell rings!)
	*/
	
	public String toString()
	{
		String returnString;
		
		/*
		if ((data.length == 4) || (data.length == 6))
		{
			returnString = new String();
		
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
		else
			returnString = new String(data);
		*/
		
		/*
		byte[] converted = new byte[data.length];
		
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == 0)
				converted[i] = 0x20;	// space character
			else
				converted[i] = data[i];
		}
		
		returnString = new String(converted);
		*/
		
		returnString = new String(data);
		
		return returnString;
		
	}
	
	
	
	private String hexByte(byte b)
	{
		int pos = b;
		if (pos < 0)
			pos += 256;
		String returnString = new String();
		returnString += Integer.toHexString(pos/16);
		returnString += Integer.toHexString(pos%16);
		return returnString;
	}
	
	
	
	/** 
	*	Returns a space-separated hex string corresponding to the raw bytes.
	*/
	
	public String toHexString()
	{
		String returnString = new String();
		
		
		for (int i = 0; i < data.length; i++)
		{
			returnString += hexByte(data[i]) + " ";
		}
		
		return returnString;
		
	}
	
	
	
}
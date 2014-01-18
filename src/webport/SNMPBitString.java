package webport;



/**
*	Class representing a general string of bits.
*/

public class SNMPBitString extends SNMPOctetString
{
	
	protected byte tag = SNMPBERCodec.SNMPBITSTRING;
		
	
	/**
	*	Create a zero-length bit string.
	*/
	
	public SNMPBitString()
	{
		this.data = new byte[0];
	}
	
	
	/**
	*	Create a bit string from the bytes of the supplied String.
	*/
	
	public SNMPBitString(String stringData)
	{
		this.data = stringData.getBytes();
	}
	
	
	/**
	*	Create a bit string from the supplied byte array. The array may be either
	*	user-supplied, or part of a retrieved BER encoding. Note that the BER encoding
	*	of the data of a bit string is just the raw bytes.
	*/
	
	public SNMPBitString(byte[] enc)
	{
		extractFromBEREncoding(enc);
	}
	
	
}
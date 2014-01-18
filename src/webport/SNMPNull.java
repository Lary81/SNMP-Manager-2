package webport;


/**
*	Object representing the SNMP Null data type.
*/

public class SNMPNull extends SNMPObject
{
	
	protected byte tag = SNMPBERCodec.SNMPNULL;
	
	
	/**
	*	Returns Java null reference.
	*/
	
	public Object getValue()
	{
		return null;
	}
	
	
	
	/**
	*	Always throws SNMPBadValueException (which null value did you want, anyway?)
	*/
	
	public void setValue(Object o)
		throws SNMPBadValueException
	{
		throw new SNMPBadValueException(" Null: attempt to set value ");
	}
	
	
	
	/**
	*	Return BER encoding for a null object: two bytes, tag and length of 0.
	*/
	
	protected byte[] getBEREncoding()
	{
		byte[] encoding = new byte[2];
		
		// set tag byte
		encoding[0] = SNMPBERCodec.SNMPNULL;
			
		// len = 0 since no payload!
		encoding[1] = 0;
		
		// no V!
		
		return encoding;
	}
	
	
	
	/**
	*	Returns String "Null"..
	*/
	
	public String toString()
	{
		return new String("Null");
	}
	
}
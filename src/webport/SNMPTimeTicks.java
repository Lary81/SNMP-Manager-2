package webport;


/**
*	SNMP datatype used to represent time value. Just extension of SNMPInteger.
*/


public class SNMPTimeTicks extends SNMPInteger
{
	
	public SNMPTimeTicks()
	{
		this(0);	// initialize value to 0
	}
	
	
	public SNMPTimeTicks(long value)
	{
		super(value);
		
		tag = SNMPBERCodec.SNMPTIMETICKS;
	}
	
	
	protected SNMPTimeTicks(byte[] enc)
		throws SNMPBadValueException
	{
		super(enc);
		
		tag = SNMPBERCodec.SNMPTIMETICKS;
	}
	
}
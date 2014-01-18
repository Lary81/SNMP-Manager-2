package webport;



import java.math.*;


/** 
*	Defines a 32-bit counter, whose value wraps if initialized with a larger
* 	value. For an indicator which "pegs" at its maximum value if initialized with
* 	a larger value, use SNMPGauge32; for a counter with a wider range, use SNMPCounter64.
* 	@see snmp.SNMPGauge32
*	@see snmp.SNMPCounter64
*/


public class SNMPCounter32 extends SNMPInteger
{
	// maximum value is 2^32 - 1
	private static BigInteger maxValue = new BigInteger("4294967295");
	
	
	
	/** Initialize value to 0.
	*/
	
	public SNMPCounter32()
	{
		this(0);	// initialize value to 0
	}
	
	
	public SNMPCounter32(long newValue)
	{
		tag = SNMPBERCodec.SNMPCOUNTER32;
		
		value = new BigInteger(new Long(newValue).toString());
		
		// wrap if value > maxValue
		value = value.mod(maxValue);
	}
	
	
	
	/** Used to initialize from the BER encoding, usually received in a response from 
	* an SNMP device responding to an SNMPGetRequest.
	* @throws SNMPBadValueException Indicates an invalid BER encoding supplied. Shouldn't
	* occur in normal operation, i.e., when valid responses are received from devices.
	*/
	
	protected SNMPCounter32(byte[] enc)
		throws SNMPBadValueException
	{
		tag = SNMPBERCodec.SNMPCOUNTER32;
		
		extractValueFromBEREncoding(enc);
		
		// wrap if value > maxValue
		value = value.mod(maxValue);
	}
	
	
	
	
	
	/** Used to set the value with an instance of java.lang.Integer or
	* java.lang.BigInteger. The value of the constructed SNMPCounter32 object is the
	* supplied value mod 2^32.
	* @throws SNMPBadValueException Indicates an incorrect object type supplied.
	*/
	
	public void setValue(Object newValue)
		throws SNMPBadValueException
	{
		if (newValue instanceof BigInteger)
		{
			value = (BigInteger)newValue;
			value = value.mod(maxValue);	// wrap when value exceeds 2^32
		}
		else if (newValue instanceof Integer)
		{
			value = new BigInteger(newValue.toString());
			value = value.mod(maxValue);	// wrap when value exceeds 2^32
		}
		else if (newValue instanceof String)
		{
			value = value = new BigInteger((String)newValue);
			value = value.mod(maxValue);	// wrap when value exceeds 2^32
		}
		else
			throw new SNMPBadValueException(" Counter32: bad object supplied to set value ");
	}
	
	
	
	
}
package webport;



import java.math.*;

/** Defines a 64-bit counter, whose value wraps if initialized with a larger
* value. For an indicator which "pegs" at its maximum value if initialized with
* a larger value, use SNMPGauge32; for a counter with a smaller range, use SNMPCounter32.
* @see snmp.SNMPGauge32
* @see snmp.SNMPCounter32
*/


public class SNMPCounter64 extends SNMPInteger
{
	// maximum value is 2^64 - 1; using approximation!!
	private static BigInteger maxValue = new BigInteger("18446744070000000000");
	
	
	/** Initialize value to 0.
	*/
	
	public SNMPCounter64()
	{
		this(0);	// initialize value to 0
	}
	
	
	public SNMPCounter64(long newValue)
	{
		tag = SNMPBERCodec.SNMPCOUNTER64;
		
		value = new BigInteger(new Long(newValue).toString());
		
		// wrap if value > maxValue
		value = value.mod(maxValue);
	}
	
	
	
	
	/** Used to initialize from the BER encoding, usually received in a response from 
	* an SNMP device responding to an SNMPGetRequest.
	* @throws SNMPBadValueException Indicates an invalid BER encoding supplied. Shouldn't
	* occur in normal operation, i.e., when valid responses are received from devices.
	*/
	
	protected SNMPCounter64(byte[] enc)
		throws SNMPBadValueException
	{
		tag = SNMPBERCodec.SNMPCOUNTER64;
		
		extractValueFromBEREncoding(enc);
		
		// wrap if value > maxValue
		value = value.mod(maxValue);
	}
	
	
	
	/** Used to set the value with an instance of java.lang.Integer or
	* java.lang.BigInteger. The value of the constructed SNMPCounter64 object is the
	* supplied value mod 2^64.
	* @throws SNMPBadValueException Indicates an incorrect object type supplied.
	*/
	
	
	public void setValue(Object newValue)
		throws SNMPBadValueException
	{
		if (newValue instanceof BigInteger)
		{
			value = (BigInteger)newValue;
			value = value.mod(maxValue);	// wrap when value exceeds 2^64
		}
		else if (newValue instanceof Integer)
		{
			value = value = new BigInteger(newValue.toString());
			value = value.mod(maxValue);	// wrap when value exceeds 2^64
		}
		else if (newValue instanceof String)
		{
			value = value = new BigInteger((String)newValue);
			value = value.mod(maxValue);	// wrap when value exceeds 2^64
		}
		else
			throw new SNMPBadValueException(" Counter64: bad object supplied to set value ");
	}
	
	
	
	
}
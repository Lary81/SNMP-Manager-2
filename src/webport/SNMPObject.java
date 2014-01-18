package webport;



/** 
*	Abstract base class of all SNMP data type classes.
*/


public abstract class SNMPObject
{
	
	/** 
	*	Must return a Java object appropriate to represent the value/data contained
	* 	in the SNMP object
	*/
	
	public abstract Object getValue();
	
	
	
	/** 
	*	Must set the value of the SNMP object when supplied with an appropriate
	* 	Java object containing an appropriate value.
	*/
	
	public abstract void setValue(Object o)
		throws SNMPBadValueException;
	
	
	
	/** 
	*	Should return an appropriate human-readable representation of the stored value.
	*/
		
	public abstract String toString();
	
	
	
	/** 
	*	Must return the BER byte encoding (type, length, value) of the SNMP object.
	*/
		
	protected abstract byte[] getBEREncoding();
	
	
}
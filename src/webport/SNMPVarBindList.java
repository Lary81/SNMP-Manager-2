package webport;

import java.util.*;




/**
*	The SNMPVarBindList class is a specialization of SNMPSequence that contains a list of
*	SNMPVariablePair objects.
*	@see snmp.SNMPVariablePair

          -- variable bindings

          VarBind ::=
                  SEQUENCE {
                      name
                          ObjectName,

                      value
                          ObjectSyntax
                  }

         VarBindList ::=
                  SEQUENCE OF
                     VarBind

         END

*/

public class SNMPVarBindList extends SNMPSequence
{
	
	/** 
	*	Create a new empty variable binding list.
	*/
	
	
	public SNMPVarBindList()
	{
		super();
	}
	
	
	
	
	
	/**
	*	Return the variable pairs in the list, separated by newlines.
	*/
	
	public String toString()
	{
		Vector sequence = (Vector)(this.getValue());
		
		String valueString = new String();
		
		for (int i = 0; i < sequence.size(); ++i)
		{
			valueString += ((SNMPObject)sequence.elementAt(i)).toString() + "\n";
		}
		
		return valueString;
	}
	
	
	
}
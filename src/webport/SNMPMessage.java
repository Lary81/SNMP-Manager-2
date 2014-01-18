package webport;

import java.util.*;



/**
*	 Defines the SNMPMessage class as a special case of SNMPSequence. Defines a
* 	top-level SNMP message, as per the following definitions from RFC 1157 and
* 	RFC 1901.


RFC1157-SNMP DEFINITIONS

     IMPORTS FROM RFC1155-SMI;

     -- top-level message

             Message ::=
                     SEQUENCE {
                          version        -- version-1 for this RFC
                             INTEGER {
                                 version-1(0)
                             },

                         community      -- community name
                             OCTET STRING,

                         data           -- e.g., PDUs if trivial
                             ANY        -- authentication is being used
                     }
                     
                     
  -- From RFC 1901:
  
  COMMUNITY-BASED-SNMPv2 DEFINITIONS ::= BEGIN

    -- top-level message

        Message ::=
                SEQUENCE {
                     version
                        INTEGER {
                            version(1)  -- modified from RFC 1157
                        },

                    community           -- community name
                        OCTET STRING,

                    data                -- PDUs as defined in [4]
                        ANY
                }
        }

    END                   

*/


public class SNMPMessage extends SNMPSequence
{
	
	
	/**
	*	Create an SNMP message with specified version, community, and pdu.
	*	Use version = 0 for SNMP version 1, or version = 1 for enhanced capapbilities
	*	provided through RFC 1157.
	*/
	
	public SNMPMessage(int version, String community, SNMPPDU pdu)
	{
		super();
		Vector contents = new Vector();
		contents.insertElementAt(new SNMPInteger(version), 0);
		contents.insertElementAt(new SNMPOctetString(community), 1);
		contents.insertElementAt(pdu, 2);
		
		try
		{
			this.setValue(contents);
		}
		catch (SNMPBadValueException e)
		{
			// can't happen! all supplied Vector elements are SNMP Object subclasses
		}
	}
	
	
	
	/**
	*	Create an SNMP message with specified version, community, and trap pdu.
	*	Use version = 0 for SNMP version 1, or version = 1 for enhanced capapbilities
	*	provided through RFC 1157.
	*/
	
	public SNMPMessage(int version, String community, SNMPTrapPDU pdu)
	{
		super();
		Vector contents = new Vector();
		contents.insertElementAt(new SNMPInteger(version), 0);
		contents.insertElementAt(new SNMPOctetString(community), 1);
		contents.insertElementAt(pdu, 2);
		
		try
		{
			this.setValue(contents);
		}
		catch (SNMPBadValueException e)
		{
			// can't happen! all supplied Vector elements are SNMP Object subclasses
		}
	}
	
	
	
	
	/**
	*	Construct an SNMPMessage from a received ASN.1 byte representation.
	*	@throws SNMPBadValueException Indicates invalid SNMP message encoding supplied.
	*/
	
	protected SNMPMessage(byte[] enc)
		throws SNMPBadValueException
	{
		super(enc);
	}
	
	
	
	/** 
	*	Utility method which returns the PDU contained in the SNMP message. The pdu is the third component
	* 	of the sequence, after the version and community name.
	*/
	
	public SNMPPDU getPDU()
		throws SNMPBadValueException
	{
		Vector contents = (Vector)(this.getValue());
		Object pdu = contents.elementAt(2);
		
		if (!(pdu instanceof SNMPPDU))
		{
			throw new SNMPBadValueException("Wrong PDU type in message: expected SNMPPDU, have " + pdu.getClass().toString());
		}
		
		return (SNMPPDU)pdu;
	}
	
	
	/** 
	*	Utility method which returns the PDU contained in the SNMP message as an SNMPTrapPDU. The pdu is the 
	*   third component of the sequence, after the version and community name.
	*/
	
	public SNMPTrapPDU getTrapPDU()
		throws SNMPBadValueException
	{
		Vector contents = (Vector)(this.getValue());
		Object pdu = contents.elementAt(2);
		
		if (!(pdu instanceof SNMPTrapPDU))
		{
			throw new SNMPBadValueException("Wrong PDU type in message: expected SNMPTrapPDU, have " + pdu.getClass().toString());
		}
		
		return (SNMPTrapPDU)pdu;
	}
	
	
	
	/** 
	*	Utility method which returns the community name contained in the SNMP message. The community name is the 
	*   second component of the sequence, after the version.
	*/
	
	public String getCommunityName()
		throws SNMPBadValueException
	{
	    Vector contents = (Vector)(this.getValue());
		Object communityName = contents.elementAt(1);
		
		if (!(communityName instanceof SNMPOctetString))
		{
			throw new SNMPBadValueException("Wrong SNMP type for community name in message: expected SNMPOctetString, have " + communityName.getClass().toString());
		}
		
		return ((SNMPOctetString)communityName).toString();
	}
	
}
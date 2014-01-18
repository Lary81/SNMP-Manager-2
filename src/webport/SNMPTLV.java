package webport;


/** 
*	Utility class holding components of an ASN.1 (type, length, value) triple.
*/

class SNMPTLV
{
	byte tag;
	int totalLength;
	byte[] value;
}
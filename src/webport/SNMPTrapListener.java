package webport;




public interface SNMPTrapListener
{
	
	public void processTrap(SNMPTrapPDU trapPDU);
	
}
package webport;

public class WebPort
{

		String NombreEquipo;
		String OIDPrinc = "1.3.6.1.4.1.12199";
		String [] ObjectID = new String[82];
		String [] Variable = new String[82];
		String []NomVar = new String[82];
		String [] Valor = new String[82];
		String [] tipoDato = new String[82];


	public WebPort() {}
	public String getNombreEquipo() {return NombreEquipo;}
	public String getOIDPrinc () {return OIDPrinc;}
	public String getObjectID (int n) {return ObjectID[n];}
	public String getVariable (int n) {return Variable[n];}
	public String getNomVar (int n) {return NomVar[n];}
	public String getValor(int n) {return Valor[n];}
	public String getTipoDato(int n) {return tipoDato[n];}


	public void setNombreEquipo(String Nombre) {NombreEquipo = Nombre;}
	public void setOIDPrinc (String OID) {OIDPrinc = OID;}
	public void setObjectID(String ID, int n) {ObjectID[n]=ID;}
	public void setVariable (String VAR, int n) {Variable[n]=VAR;}
	public void setNomVar (String VAR, int n) {NomVar[n]=VAR;}
	public void setValor (String VAR, int n) {Valor [n] = VAR;}
	public void setTipoDato (String VAR, int n) {tipoDato [n] = VAR;}

}

package webport;


import java.io.*;


public class WPArch
{
		WebPort WebPort = new WebPort();
		String unaMib;
		BufferedReader lector = null;
	public WPArch(WebPort WP3)
	{
		WebPort=WP3;
		try
		{
		FileReader WebPArch;

		WebPArch = new FileReader("WebPort.dat");
		lector = new BufferedReader(WebPArch);
		}
		catch(IOException e){System.out.println(e.getMessage());}
	}



	public void leer()
	{

		System.out.println ("Fichero: WebPort.dat");
		try
		{
			int i=0;
			while ((unaMib = lector.readLine())!=null){
				WebPort.setVariable(unaMib,i);
				unaMib = lector.readLine();
				WebPort.setNomVar(unaMib,i);
				unaMib = lector.readLine();
				WebPort.setObjectID(unaMib, i);
				unaMib = lector.readLine();
				WebPort.setValor(unaMib, i);
				unaMib = lector.readLine();
				WebPort.setTipoDato(unaMib, i);
				i=i+1;}
	//			for (i=0;i<42;i++){messagesArea.append(WebPort.getObjectID(i));}

		}
		catch(IOException e)

		{

			System.out.println(e.getMessage());
		}
		try
		{
			if(lector != null)
			lector.close();
		}
		catch (IOException e){System.out.println(e.getMessage());}
	}



}
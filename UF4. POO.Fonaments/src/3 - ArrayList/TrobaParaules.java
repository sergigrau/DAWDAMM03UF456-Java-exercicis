
/**Classe que troba la posici— d'una paraula  entre
 * una llista introdu•da per l'entrada estˆndard.
 * classe compatible amb JDK < 1.5
 * @author sergi grau
 * @version 14/01/2010
 */
import java.io.*;
import java.util.*;

public class TrobaParaules {
	public static void main (String[] args) throws IOException{
		String[] vParaules = null;
		TrobaParaules p = new TrobaParaules ();
		vParaules= p.llegeixTeclat("entra cadena: ").split(" ");
		System.out.println(Arrays.binarySearch(vParaules,p.llegeixTeclat("entra paraula a cercar: ")));
	}
	private String llegeixTeclat(String miss)throws IOException{
		String linia=null;
		System.out.println(miss);
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		linia=buf.readLine();	
		return linia;
	}
}


/**Classe que troba la posició d'una paraula  entre
 * una llista introdu•da per l'entrada estˆndard.
 * classe compatible amb JDK >= 1.5
 * @author sergi grau
 * @version 14/01/2010
 */
import java.io.*;
import java.util.*;

public class TrobaParaules2 {
	public static void main (String[] args) throws IOException{
		ArrayList<String> vParaules = new ArrayList<String>();
		TrobaParaules2 p = new TrobaParaules2 ();
		StringTokenizer st = new StringTokenizer(p.llegeixTeclat("entra cadena: "));
		while (st.hasMoreTokens()){
			vParaules.add(st.nextToken());
		}
		System.out.println(vParaules.indexOf(p.llegeixTeclat("entra paraula a cercar: ")));
	}
	private String llegeixTeclat(String miss)throws IOException{
		String linia=null;
		System.out.println(miss);
		Scanner entrada = new Scanner(System.in);
		return entrada.nextLine();
	}
}

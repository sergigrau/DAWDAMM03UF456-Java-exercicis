import java.util.*;
/**
 * Classe que determina el nombre d'aparicions d'una paraula en una altra
 * @author sergi grau sergi.grau@fje.edu
 * @version 1.0
 * @date 1.1.2018
 *
 */
public class TrobaParaula {
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		String paraulaACercar=entrada.nextLine();
		String paraulaOnCercar= entrada.nextLine();
		int numAparicions=0;
		int posicio=0;
		while((posicio=paraulaOnCercar.indexOf(paraulaACercar,posicio))!=-1){
			posicio++;
			numAparicions++;
		}
		
		System.out.println(numAparicions);

	}
}

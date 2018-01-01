import java.util.*;
/**
 * Classe que determina el nombre d'aparicions de cadascuna de les lletres
 * @author sergi grau. 
 *
 */
public class NombreAparicions {

	public static void main(String[] args) {
		int[] lletres = new int[26];
		Scanner entrada = new Scanner(System.in);
		String paraula=entrada.nextLine();
		for(int i=0;i<paraula.length();i++){
			lletres[paraula.charAt(i)-65]++;
		}
		char lletra= 65;
		for(int i=0;i<26;i++){
			
			System.out.println((lletra++)+":"+lletres[i]+"\t");
		}
	}

}

import java.util.*;

/**
 * Classe que calcula la informació més important d'una xarxa 
 * a partir de l'adreça d'una màquina i la màscara de xarxa que té associada.
 * @author sergi grau. etpc 2007
 *
 */
public class DeterminaXarxa {
	private static short[] bytesIP; 
	public static void main(String[] args){
		//descartem el byte que va de +- 2^7-1
		bytesIP= new short[4];
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("IP:");
		bytesIP= estreuBytesAdreçaIP(entrada.nextLine());
		System.out.println("classe " + classeXarxa(bytesIP[0]));
	}
	
	private static short[] estreuBytesAdreçaIP(String adreçaIP){
		short[] taula=new short[4];
		String[] cadena= adreçaIP.split("\\D"); //D expressió reg per no digits"
		for(int i=0; i<4;i++){
			taula[i]=Short.parseShort(cadena[i]);
		}
		return taula;
	}
	
	private static String classeXarxa(short primerByte){
		if (primerByte<128){
			return "A";
		}
		else if (primerByte<192){
			return "B";
		}
		else{
			return "C";
		}
	}

}

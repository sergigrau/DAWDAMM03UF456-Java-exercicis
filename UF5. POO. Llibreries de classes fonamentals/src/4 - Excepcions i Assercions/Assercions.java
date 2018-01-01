import java.util.Scanner;

/**
 * Classe principal que llegeix per l'entrada estˆndard i tracta els possibles
 * errors mitjanant assercions
 * 
 * cal passar el parˆmetre -ea a la JVM
 * 
 * @author sergi grau
 * @version 1.0, 28.01.2010
 * 
 */
public class Assercions {

	public static void main(String[] args) {

		boolean problema = false;
		do {
			problema = false;
			try {
				System.out.println(llegirEntrada());
			} catch (AssertionError e) {
				problema = true;
				System.out.println("problemes amb el dni");
			}
		} while (problema);

	}

	/**
	 * mtode de classe que retorna la cadena llegida
	 * 
	 * @return
	 */
	public static String llegirEntrada() {
		Scanner entrada = new Scanner(System.in);
		String campDNI = entrada.nextLine();
		assert campDNI.length() != 0;
		assert campDNI.length() == 8;
		long dni = Long.parseLong(campDNI);
		assert dni > 10000000;
		return campDNI;
	}

}
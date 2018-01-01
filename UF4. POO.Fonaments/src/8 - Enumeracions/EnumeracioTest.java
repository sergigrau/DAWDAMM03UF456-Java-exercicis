import java.util.*;

/**
 * Classe que demostra el funcionamet d'una classe d'enumeració
 * 
 * @author sergi grau
 * @version 15.01.2010
 */
public class EnumeracioTest {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("entra una nota:");

		Nota nota = Enum.valueOf(Nota.class, entrada.next().toUpperCase());
		
		Alumne alumne = new Alumne("sergi", nota);
		System.out.println(alumne);
	}
}

/**
 * Classe d'enumeració Nota
 * 
 * @author sergi grau
 * @version 15.01.2010
 */
enum Nota {
	INSUFICIENT("I"), SUFICIENT("S"), BE("B"), NOTABLE("N"), EXCELLENT("E");
	
	private String abreviatura;
	
	private Nota(String abbreviation) {
		this.abreviatura = abbreviation;
	}

	public String getAbreviatura() {
		return abreviatura;
	}


}

/**
 * Classe Alumne
 * 
 * @author sergi grau
 * @version 15.01.2010
 */
class Alumne {
	private String nom;
	private Nota nota;

	public Alumne(String nom, Nota nota) {
		super();
		this.nom = nom;
		this.nota = nota;
	}

	public String toString() {

		String observacio= "";
		if (nota == Nota.INSUFICIENT){
			observacio = " has de treballar més";
		}
			
		return nom + "-" + nota.getAbreviatura() + observacio;
	}

}
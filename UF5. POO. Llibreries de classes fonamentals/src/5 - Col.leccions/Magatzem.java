import java.util.*;

/**
 * Classe que representa un magatzem
 * 
 * @author sergi grau
 * @version 1.0, 06.03.2010
 */

public class Magatzem {

	private ArrayList<Producte> productes = null;

	public Magatzem() {
		productes = new ArrayList<Producte>();
	}

	/**
	 * Mètode que afegeix un producte al magatzem
	 * 
	 * @param p
	 *            producte a afegir
	 */
	public void afegirProducte(Producte p) {
		productes.add(p);
	}

	/**
	 * Mètode que retorna un producte, a partir del seu nom
	 * 
	 * @param nom
	 * @return prouducte obtingut
	 */
	public Producte obtenirProducte(String nom, Pes p) {
		return productes.get(productes.indexOf(new Producte(nom, p)));
	}

	/**
	 * Mètode que presenta per la sortida estandard tots els productes
	 */
	public void llistarProductes() {
		Collections.sort(productes);
		for (Producte p : productes)
			System.out.println(p.getNom() + " " + p.getPes());

	}

	/**
	 * Mètode principal que executa un joc de proves
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Producte p1 = new Producte();
		Producte p2 = new Producte();
		Producte p3 = new Producte();
		Pes pes1 = new Pes(Unitat.GRAMS, 100);
		Pes pes2 = new Pes(Unitat.GRAMS, 200);

		p1.setNom("beta");
		p2.setNom("alfa");
		p3.setNom("beta");
		p1.setPes(pes1);
		p2.setPes(pes1);
		p3.setPes(pes2);

		Magatzem magatzem = new Magatzem();
		magatzem.afegirProducte(p1);
		magatzem.afegirProducte(p2);
		magatzem.afegirProducte(p3);
		
		magatzem.llistarProductes();
		System.out.println(magatzem.obtenirProducte("alfa",pes1).getNom());
	}

}

/**
 * Classe que representa una entitat Producte. Implementa la interfície
 * Comparable per a poder comparar Productes (primer per nom i després per Pes)
 * 
 * @author sergi grau
 * @version 1.0, 06.03.2010
 * 
 */
class Producte implements Comparable<Producte> {

	private String nom;
	private Pes p; // Pes és una enumeració

	/**
	 * Constructor sense paràmetres
	 */
	public Producte() {

	}

	/**
	 * Constructor amb dos paràmetres
	 * 
	 * @param nom
	 * @param p
	 */
	public Producte(String nom, Pes p) {
		super();
		this.nom = nom;
		this.p = p;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String n) {
		nom = n;
	}

	public Pes getPes() {
		return p;
	}

	public void setPes(Pes q) {
		this.p = q;
	}
	/**
	 * Mètode que compara dos productes
	 */
	@Override
	public boolean equals(Object o){
		if (this==o) return true;
		if (o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Producte prod = (Producte)o;
		return prod.nom.equals(nom) && prod.p.equals(getPes()) ;
		
	}
	/**
	 * Mètode que compara dos productes
	 */
	@Override
	public int compareTo(Producte o) {
		if (this.getNom().equals(o.getNom())) {
			if (this.p.getValor() > o.getPes().getValor()) {
				return 1;
			} else if (this.p.getValor() < o.getPes().getValor()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return (this.getNom().compareTo(o.getNom()));

		}

	}
}
/**
 * Classe que representa un Pes i que serveix per a implementar el patró Quantity
 * @author sergi grau
 * @version 1.0, 06.03.2010
 *
 */
class Pes {
	private Unitat unitat;
	private int valor;

	public Pes(Unitat u, int v) {
		unitat = u;
		setValor(v);
	}

	public String getUnitat() {
		return unitat.getAbbreviation();
	}

	public void setUnitat(String aUnitat) {
		unitat = (Unitat) Enum.valueOf(Unitat.class, aUnitat);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String toString() {
		return getUnitat() + "," + getValor();
	}
}
/**
 * Enumeració relativa a les unitats
 * @author sergi grau
 * @version 1.0, 06.03.2010
 *
 */
enum Unitat {
	GRAMS("gr"), LLIURES("ll");
	private String abrev;

	private Unitat(String aAbrev) {
		this.abrev = aAbrev;
	}

	public String getAbbreviation() {
		return abrev;
	}

}
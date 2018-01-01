import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe que representa una Factura. Implementa les interfícies Comparable per
 * poder definir una relació d'ordre basada en la data de la factura, i deep
 * copy
 * 
 * @author sergi grau
 * @version 1.0, 16.01.2014
 */
public class Factura implements Comparable<Factura>, Cloneable {

	private double importFactura;
	private String concepte;
	private Date data;//data de pagament de la factura

	/**
	 * Constructor amb 3 paràmetres
	 * 
	 * @param importFactura
	 * @param concepte
	 * @param data
	 */
	public Factura(double importFactura, String concepte, Date data) {
		this.importFactura = importFactura;
		this.concepte = concepte;
		this.data = data;
	}

	@Override
	public int compareTo(Factura o) {
		return data.compareTo(o.data);
	}
	//abans calia que retornes Object, ja no cal
	@Override
	protected Factura clone() throws CloneNotSupportedException {
		
			Factura copiaFactura = (Factura) super.clone();
			copiaFactura.data= (Date)data.clone();
			return copiaFactura;
	}

	@Override
	public String toString() {

		return obtenirImport() + "\t" + concepte + "\t" + data;
	}

	public void setData(int any, int mes, int dia) { 
		Date d = new GregorianCalendar(any, mes- 1, dia).getTime(); 
		data.setTime(d.getTime()); 
	}

	public Date getData() {
		return data;
	}
	/**
	 * Mètode que es crida quan es paga efectivament una factura
	 * @return l'import de la factura a pagar
	 */
	public double obtenirImport() {
		return importFactura;
	}
}

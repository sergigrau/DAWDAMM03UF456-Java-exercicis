import java.util.*;


/**
 * Classe que hereta de Factura i que presenta una Factura Postdatada.
 * Les factures postades realizten un descompte en l'import si les
 * factures són pagades abans d'una data.
 * 
 * @author sergi grau
 * @version 1.0, 16.01.2014
 */
public class FacturaPosDatada extends Factura {

	private double descompte;
	private int diesPagament;
	/**
	 * Constructor amb 3 paràmetres
	 * @param importFactura
	 * @param concepte
	 * @param data
	 */
	public FacturaPosDatada(double importFactura, String concepte, Date data) {
		super(importFactura, concepte, data);
		
	}
	
	public FacturaPosDatada(double importFactura, String concepte, Date data,
			double descompte, int diesPagament) {
		super(importFactura, concepte, data);
		this.descompte = descompte;
		this.diesPagament = diesPagament;
	}
	/**
	 * Mètode que es crida quan es paga efectivament una factura.
	 * @return l'import de la factura a pagar
	 */
	public double obtenirImport(){
		double importFinal= super.obtenirImport();
		return importFinal*= (1-descompte/100);		
	}
}

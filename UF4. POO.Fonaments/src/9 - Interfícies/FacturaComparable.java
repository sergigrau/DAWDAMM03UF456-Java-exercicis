import java.util.*;


/**
 * Classe Principal que crea una col.lecció d'objectes de la classe Factura i
 * FacturaPostdatada
 * 
 * @author sergi grau
 * @version 1.0, 15.01.2014
 * 
 */
public class FacturaComparable {

	public static void main(String[] args) {
		
		List<Factura> llistaFactures = new ArrayList<Factura>();

		llistaFactures.add(new Factura(400, "mòbil Android",
				new GregorianCalendar(2010, 0, 2).getTime()));
		llistaFactures.add(new Factura(1000, "ordinador",
				new GregorianCalendar(2010, 1, 10).getTime()));
		llistaFactures.add(new Factura(150, "disc dur", new GregorianCalendar(
				2009, 0, 1).getTime()));
		// provem les factures postdatades
		llistaFactures.add(new FacturaPosDatada(300, "netbook xyz",
				new GregorianCalendar(2010, 0, 16).getTime(), 10, 10));

		// per verificar que la copia d'objs es correcte
		Factura factura = new Factura(1000, "mòbil iPhone",
				new GregorianCalendar(2010, 10, 2).getTime());
		Factura copiaFactura = null;
		try {
			copiaFactura = factura.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// canviem la data per veure que funciona el deep copy
		copiaFactura.setData(2008,1,10);
		llistaFactures.add(factura);
		llistaFactures.add(copiaFactura);
		Collections.sort(llistaFactures);
		for (Factura f : llistaFactures) {
			System.out.println(f);
		}
	}

}

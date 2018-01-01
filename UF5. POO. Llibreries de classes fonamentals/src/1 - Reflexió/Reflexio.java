
import java.lang.reflect.*;
/**
 * @author Sergi Grau
 * /
public class Reflexio {

	public static void main(String[] args) {
		
			try{
				//Class cl = Class.forName("java.util.Date");
				Class cl = Class.forName("FacturaBean");
				Field[] fields = cl.getDeclaredFields();
				
				for (Field f : fields)
				{
					Class type = f.getType();
					String name = f.getName();
					System.out.print(" ");
					String modifiers = Modifier.toString(f.getModifiers());
					if (modifiers.length() > 0) System.out.print(modifiers + " ");
					System.out.println(type.getName() + " " + name + ";");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
}

class PersonaBean implements java.io.Serializable {
	private String nom;
	private Integer edat;

	// Constructor per defecte (sense arguments).
	public PersonaBean() {
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getEdat() {
		return this.edat;
	}

	public void setEdat(Integer edat) {
		this.edat = edat;
	}
}

class FacturaBean implements java.io.Serializable {
	private int codi;
	private String client;
	private double importFactura;

	// Constructor per defecte (sense arguments).
	public FacturaBean() {
	}

	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getImportFactura() {
		return importFactura;
	}

	public void setImportFactura(double importFactura) {
		this.importFactura = importFactura;
	}

}

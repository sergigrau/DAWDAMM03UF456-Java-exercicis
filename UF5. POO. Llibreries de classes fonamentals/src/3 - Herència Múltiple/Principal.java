import java.util.*;

/**
 * Classe principal del sistema.
 * 
 * @author sergi grau
 * @version 1.0, 18.01.2010
 */
public class Principal {

	public static void main(String[] args) {

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Scanner entrada = new Scanner(System.in);
		do {
			vehicles.add(crearVehicle());
			System.out.println("voleu crear un nou vehicle [S]i/[N]o ?");
		} while (entrada.next().equalsIgnoreCase("S"));

		Collections.sort(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}

	}

	private static Vehicle crearVehicle() {
		System.out
				.println("quin vehicle voleu crear ? [C]otxe/c[A]mio/[F]urgoneta/[M]onovolum");

		Vehicle v = null;
		Scanner entrada = new Scanner(System.in);

		String tipusVehicle = entrada.next();
		System.out.println("model");
		entrada = new Scanner(System.in);
		String model = entrada.nextLine();
		System.out.println("potencia");
		entrada = new Scanner(System.in);
		int potencia = entrada.nextInt();
		System.out.println("color");
		entrada = new Scanner(System.in);
		String color = entrada.nextLine();
		// manca implementar matr’cula
		if (tipusVehicle.equalsIgnoreCase("C")) {
			v = new Cotxe(model, potencia, color, 0, 0); // manca llegir
			// atCributs propis
		} else if (tipusVehicle.equalsIgnoreCase("A")) {
			v = new Camio(model, potencia, color, 0, 0, 0); // manca llegir
			// atributs propis

		} else if (tipusVehicle.equalsIgnoreCase("F")) {
			v = new FurgonetaImpl(model, potencia, color, false, 0); // manca
																		// llegir
			// atributs propis

		} else if (tipusVehicle.equalsIgnoreCase("M")) {
			v = new Monovolum(model, potencia, color, 0, 0, false, 0, false); // manca
																				// llegir
			// atributs propis
		}
		return v;

	}
}

/**
 * Classe CalendarTest. Mostra un calendari del mes actual
 * prof. Sergi Grau. ETPC. DAI-2. basat en codi de Cay S. Horstmann, Gary Cornell
 */
import java.util.*;

public class CalendarTest {
	public static void main(String[] args) {
		// instànciem un objecte d de tipus GregorianCalendar 
		// amb la data i hora actual
		GregorianCalendar d = new GregorianCalendar();

		
		int avui = d.get(Calendar.DAY_OF_MONTH);
		int mes = d.get(Calendar.MONTH);

		// assignem el primer dia del mes
		d.set(Calendar.DAY_OF_MONTH, 1);

		int diaSetmana = d.get(Calendar.DAY_OF_WEEK);

		// imprimim capaçalera
		System.out.println("Dg  Dl  Dm  Dc  Dj  Dv  Ds ");

		// calculem identació de la primera línia del calendari
		for (int i = Calendar.SUNDAY; i < diaSetmana; i++)
			System.out.print("    ");

		do {
			// printem dia
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);

			// marquem el dia actual amb *
			if (day == avui)
				System.out.print("*");
			else
				System.out.print(" ");

			// iniciem una nova línia després de diumenge
			if (diaSetmana == Calendar.SATURDAY)
				System.out.println();

			// augmentem d al següent dia del mes
			d.add(Calendar.DAY_OF_MONTH, 1);
			diaSetmana = d.get(Calendar.DAY_OF_WEEK);
		} while (d.get(Calendar.MONTH) == mes);
		// fins que trobem el dia 1 del següent mes

		// línia final si es necessaria
		if (diaSetmana != Calendar.SUNDAY)
			System.out.println();
	}
}

import java.util.ArrayList;

/**Examen JAVA
 * @version Desembre 2004
 * @author sergi grau
 */
public class Principal {

	public static void main(String[] args) {
	//Aquesta part verifica el correcte funcionament de l'exercici 1
		NIF nif1=new NIF(40555666);
		NIF nif2=new NIF(30111000);
		System.out.println(nif1.toString());
		System.out.println(nif2.toString());
		
	//Aquesta part verifica el correcte funcionamet de l'exercici 2
		Persona per1=new Persona();
		per1.setNom("Joana");
		per1.setNIF(55566612);
		System.out.println(per1.toString());
		
	//Aquesta part verifica el correcte funcionamet de l'exercici 3
		Alumne a1=new Alumne();
		Professor p1=new Professor();
		a1.setNom("Joan");
		a1.setNIF(123456);
		a1.setNumAlumne(0001);
		p1.setNIF(123456);
		p1.setNom("Sergi");
		p1.setSou(1000);
		System.out.println(a1.toString()+ " i NIF "+ a1.getNIF());
		System.out.println(p1.toString()+ " i NIF "+ p1.getNIF());
                System.out.println(a1.equals(p1));
		
//		Aquesta part verifica el correcte funcionamet de l'exercici 4
		//Alumne a1=new Alumne();
		Alumne a2=new Alumne();
		//Professor p1=new Professor();
		a1.setNom("Joan");
		a1.setNIF(123456);
		a1.setNom("Marta");
		a1.setNIF(111111);
		p1.setNIF(123456);
		p1.setNom("Sergi");
		

                ArrayList<Persona> persones = new ArrayList<Persona>();
                persones.add(a1);
                persones.add(p1);
                for (Persona p : persones){
                    System.out.println("sortida"+ p);
                }
	}
	
	
}

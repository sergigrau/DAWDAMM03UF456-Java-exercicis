import java.util.InputMismatchException;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sergi grau
 */
public class CRUD {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ServeiEmpleat");
    private static EntityManager em = null;
    private static ServeiEmpleat servei;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        em = emf.createEntityManager();
        servei = new ServeiEmpleat(em);
        menuTractamentEmpleats();

    }

    /**
     * Mètode estàtic que crea el menu amb les opcions
     *
     * @throws InputMismatchException Excepció corresponent a la introducció d'una tecla
     */
    public static void menuTractamentEmpleats() throws InputMismatchException {

        int opcio;
        do {
            System.out.println("1. Crea Empleat");
            System.out.println("2. Consulta empleat per codi");
            System.out.println("3. Consulta tots els empleats");
            System.out.println("4. Modifica salari segon codi");
            System.out.println("5. Esborrar segon codi");
            System.out.println("6. Surt");
            Scanner entrada = new Scanner(System.in);
            opcio = entrada.nextInt();

            switch (opcio) {
                case 1:
                    entrada = new Scanner(System.in);
                    System.out.print("codi:");
                    int id = entrada.nextInt();
                    entrada = new Scanner(System.in);
                    System.out.print("nom:");
                    String nom = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.print("salari:");
                    long salari = entrada.nextLong();
                    crearEmpleat(id, nom, salari);
                    break;
                case 2:
                    entrada = new Scanner(System.in);
                    System.out.print("id:");
                    trobarEmpleat(entrada.nextInt());

                    break;
                case 3:
                    trobarTotsEmpleats();
                    break;
                case 4:
                    entrada = new Scanner(System.in);
                    System.out.print("id:");
                    augmentarSalariEmpleat(entrada.nextInt(), 10L);
                    break;
                case 5:
                    entrada = new Scanner(System.in);
                    System.out.print("id:");
                    esborrarEmpleat(entrada.nextInt());
                    break;

                case 6:
                    em.close();
                    emf.close();
                    break;
                default:
                    System.out.println("opció incorrecta");
                    break;
            }
        } while (opcio != 6);
    }

    public static void crearEmpleat(int id, String nom, long salari) {
        em.getTransaction().begin();
        Empleat emp = servei.crearEmpleat(id, nom, salari);
        em.getTransaction().commit();
        System.out.println("s'ha fet persistent " + emp);
    }

    public static void trobarEmpleat(int id) {
        Empleat emp = servei.trobarEmpleat(id);
        System.out.println("Found " + emp);
    }

    public static void trobarTotsEmpleats() {
        List<Empleat> emps = servei.trobarTotsEmpleats();
        for (Empleat e : emps) {
            System.out.println("Found employee: " + e);
        }
    }

    public static void augmentarSalariEmpleat(int id, long augment) {
        em.getTransaction().begin();
        Empleat emp = servei.augmentarSalariEmpleat(id, augment);
        em.getTransaction().commit();
        System.out.println("Updated " + emp);
    }

    public static void esborrarEmpleat(int id) {
        em.getTransaction().begin();
        servei.esborrarEmpleat(id);
        em.getTransaction().commit();
        System.out.println("Removed Employee 158");
    }
}

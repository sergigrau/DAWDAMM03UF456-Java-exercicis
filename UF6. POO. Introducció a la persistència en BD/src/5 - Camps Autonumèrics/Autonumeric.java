import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Classe que realitza operacions sobre una taula Alumne. Utilitza una classe d'utilitat per a gestionar la connexió a
 * la BD i els camps són autonumèrics
 *
 * @author sergi grau
 * @version 1.0 6.02.2012
 */
public class Autonumeric {

    private static Connection conn;
    private static Statement stmt;
    private static BDAccessor bd= null;

    public static void main(String args[])  {

         bd = new BDAccessor();
        try {
            conn = bd.obtenirConnexio();

            menuTractamentAlumnes();
        } catch (InputMismatchException ex) {
            System.out.println("opció incorrecta");
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Mètode estàtic que crea el menu amb les opcions
     *
     * @throws SQLException
     * @throws IOException
     * @throws InputMismatchException Excepció corresponent a la introducció d'una tecla
     */
    public static void menuTractamentAlumnes() throws SQLException, IOException, InputMismatchException, ClassNotFoundException {
   
        int opcio;
        do {
            System.out.println("1. Afegeix alumne");
            System.out.println("2. Consulta tots els alumnes");
            System.out.println("3. Consulta alumnes segons nota");
            System.out.println("4. Surt");
            Scanner entrada = new Scanner(System.in);
            opcio = entrada.nextInt();

            switch (opcio) {
                case 1:
                    entrada = new Scanner(System.in);
                    System.out.print("nom:");
                    String nom = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.print("nota:");
                    float nota = entrada.nextFloat();
                    afegirAlumne(nom, nota);
                    break;
                case 2:
                    consultarAlumnes();
                    break;
                case 3:
                    entrada = new Scanner(System.in);
                    System.out.print("nota:");
                    String condicio = entrada.nextLine();
                    consultarAlumnes(condicio);
                    break;
                case 4:
                    conn.close();
                    break;
                default:
                    System.out.println("opció incorrecta");
                    break;
            }
        } while (opcio != 4);
    }

    public static void afegirAlumne(String nom, float nota) throws SQLException {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO alumneAutoinc(nom,nota) VALUES ('" + nom + "'," + nota + ")", Statement.RETURN_GENERATED_KEYS);
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                while (rs.next()) {
                    System.out.println("Codi generat per getGeneratedKeys():"
                            + rs.getInt(1));
                }
            }
            System.out.println("S'ha afegit " + stmt.getUpdateCount() + " items");
            conn.commit();
        } finally {
        }
    }

    /**
     * Mètode que mostra tots els alumnes
     *
     * @throws SQLException
     */
    public static void consultarAlumnes() throws SQLException {

        try {
            stmt = conn.createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM alumneAutoinc");
            while (resultat.next()) {
                System.out.println(resultat.getInt(1)
                        + "-" + resultat.getString(2)
                        + "-" + resultat.getString(3));
            }
            resultat.close();
            stmt.close();
        } finally {
        }
    }
    /*
     * Mostra tots els alumnes que compleixen la condició
     */

    public static void consultarAlumnes(String condicio) throws SQLException {

        try {
            stmt = conn.createStatement();
            try (ResultSet resultat = stmt.executeQuery("SELECT * FROM alumneAutoinc WHERE nota " + condicio)) {
                while (resultat.next()) {
                    System.out.println(resultat.getInt(1)
                            + "-" + resultat.getString(2)
                            + "-" + resultat.getString(3));
                }
            }

        } finally {
        }
    }

    
}
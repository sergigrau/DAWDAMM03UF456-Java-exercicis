import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Classe que permet el tractament d'alumnes en una taula Alumne
 *
 * @author sergi grau
 * @version 1.0, 02.03.2010
 */
public class TractamentAlumnesNotes {

    private static Connection conn;

    public static void main(String args[]) {
        try {
            menuTractamentAlumnes();
        } catch (InputMismatchException ex) {
            System.out.println("opció incorrecta");
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } catch (IOException ex) {
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
    public static void menuTractamentAlumnes() throws SQLException, IOException, InputMismatchException {

        conn = obtenirConnexio();
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
                    System.out.print("codi:");
                    entrada = new Scanner(System.in);
                    int codi = entrada.nextInt();
                    entrada = new Scanner(System.in);
                    System.out.print("nom:");
                    String nom = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.print("nota:");
                    float nota = entrada.nextFloat();
                    afegirAlumne(codi, nom, nota);
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

    public static void afegirAlumne(int codi, String nom, float nota) throws SQLException {
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO alumne VALUES ("
                    + codi + ", '"
                    + nom + "',"
                    + nota + ")");
            System.out.println("S'ha afegit " + stat.getUpdateCount() + " items");

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
            Statement stat = conn.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT * FROM alumne");
            while (resultat.next()) {
                System.out.println(resultat.getInt(1)
                        + "-" + resultat.getString(2)
                        + "-" + resultat.getString(3));
            }
            resultat.close();
            stat.close();
        } finally {
        }
    }
    /*
     * Mostra tots els alumnes que compleixen la condició
     */

    public static void consultarAlumnes(String condicio) throws SQLException {

        try {
            Statement stat = conn.createStatement();
            ResultSet resultat = stat.executeQuery("SELECT * FROM alumne WHERE nota " + condicio);
            while (resultat.next()) {
                System.out.println(resultat.getInt(1)
                        + "-" + resultat.getString(2)
                        + "-" + resultat.getString(3));
            }
            resultat.close();
            stat.close();
        } finally {
        }
    }

    /**
     * Relitza una connexi a la BD, a partir de les propietats especificades en un fitxer database.properties
     *
     * @return la connexi amb la BD
     */
    public static Connection obtenirConnexio() throws SQLException, IOException {
        
        Properties propietats = new Properties();
        FileInputStream fitxerEntrada = new FileInputStream(System.getProperty("user.dir")+ "/src/exercicis/database.properties");
        propietats.load(fitxerEntrada);
        fitxerEntrada.close();

        String drivers = propietats.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = propietats.getProperty("jdbc.url");
        String usuari = propietats.getProperty("jdbc.username");
        String contrasenya = propietats.getProperty("jdbc.password");

        return DriverManager.getConnection(url, usuari, contrasenya);
    }
}
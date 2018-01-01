import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.sql.rowset.CachedRowSet;

/**
 * Classe que realitza operacions amb un RowSet amb desplaçament i actualitzable. Utilitza una classe d'utilitat per a
 * gestionar la connexió a la BD. Utilitza Sentències preparades
 *
 * @author sergi grau (sergi.grau@fje.edu)
 * @version 1.0 18.02.2014
 */
public class RowSet {

    private static CachedRowSet crs = null;

    public static void main(String args[]) {

        try {

            crs = new com.sun.rowset.CachedRowSetImpl();
            crs.setUrl("jdbc:mysql://localhost:3306/daw2?autoReconnect=true&relaxAutoCommit=true");
            crs.setUsername("root");
            crs.setPassword("root");
            crs.setCommand("SELECT * FROM alumne");
            crs.setConcurrency(CachedRowSet.CONCUR_UPDATABLE);
            crs.setType(CachedRowSet.TYPE_SCROLL_SENSITIVE);
          
           
            crs.execute();

            crs.last();
            System.out.println("nombre de registres " + crs.getRow());
            crs.beforeFirst();

            consultaModificacioResultSet();

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
    public static void consultaModificacioResultSet() throws SQLException, IOException, InputMismatchException, ClassNotFoundException {

        String opcio;
        do {
            System.out.println("S:seguent | A:anterior | P:primer | U:ultim | C:crear | E:esborrar | M:modificar | X:SORTIR");
            Scanner entrada = new Scanner(System.in);
            opcio = entrada.next();

            switch (opcio) {
                case "S":
                    if (crs.next()) {
                        System.out.println(crs.getString("nom") + "-" + crs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "A":
                    if (crs.previous()) {
                        System.out.println(crs.getString("nom") + "-" + crs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "P":
                    if (crs.first()) {
                        System.out.println(crs.getString("nom") + "-" + crs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "U":
                    if (crs.last()) {
                        System.out.println(crs.getString("nom") + "-" + crs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "C":

                    entrada = new Scanner(System.in);
                    System.out.println("codi: ");
                    int codi = entrada.nextInt();
                    entrada = new Scanner(System.in);
                    System.out.println("nom: ");
                    String nom = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("nota: ");
                    float nota = entrada.nextFloat();

                    crs.moveToInsertRow();
                    crs.updateInt("codi", codi);
                    crs.updateString("nom", nom);
                    crs.updateFloat("nota", nota);
                    crs.insertRow();
                    crs.moveToCurrentRow();

                    break;
                case "E":
                    crs.deleteRow();
                    System.out.println("registre esborrat");

                    break;

                case "M":

                    entrada = new Scanner(System.in);
                    System.out.println("nota: ");

                    crs.updateDouble("nota", entrada.nextFloat());
                    crs.updateRow();
                    break;


                case "X":
                    
                    crs.acceptChanges();
                    crs.close();
                    break;
                default:
                    System.out.println("opció incorrecta");
                    break;
            }

        } while (!opcio.equalsIgnoreCase(
                "X"));
    }
}

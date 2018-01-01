import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que realitza operacions amb un ResultSet amb desplaçament i actualitzable. Utilitza una classe d'utilitat per
 * a gestionar la connexió a la BD. Utilitza Sentències preparades
 *
 * @author sergi grau (sergi.grau@fje.edu)
 * @version 1.0 18.02.2014
 */
public class ResultSetDesplacableActualitzable {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static BDAccessor bd = null;
    private static ResultSet rs = null;

    public static void main(String args[]) {

        bd = new BDAccessor();
        try {
            conn = bd.obtenirConnexio();
            String cadenaSQL = "SELECT codi, nom, nota FROM alumne";
            pstmt = conn.prepareStatement(cadenaSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pstmt.executeQuery();
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
                    if (rs.next()) {
                        System.out.println(rs.getString("nom") + "-" + rs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "A":
                    if (rs.previous()) {
                        System.out.println(rs.getString("nom") + "-" + rs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "P":
                    if (rs.first()) {
                        System.out.println(rs.getString("nom") + "-" + rs.getFloat("nota"));
                    } else {
                        System.out.println("no queden mes registres");
                    }

                    break;
                case "U":
                    if (rs.last()) {
                        System.out.println(rs.getString("nom") + "-" + rs.getFloat("nota"));
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

                    rs.moveToInsertRow();
                    rs.updateInt("codi", codi);
                    rs.updateString("nom", nom);
                    rs.updateFloat("nota", nota);
                    rs.insertRow();
                    rs.moveToCurrentRow();

                    break;
                case "E":
                    rs.deleteRow();
                    System.out.println("registre esborrat");

                    break;

                case "M":

                    entrada = new Scanner(System.in);
                    System.out.println("nota: ");

                    rs.updateDouble("nota", entrada.nextFloat());
                    rs.updateRow();
                    break;


                case "X":
                    conn.commit();
                    BDAccessor.tancarPreparedStatement(pstmt);
                    BDAccessor.tancarConnexio(conn);
                    break;
                default:
                    System.out.println("opció incorrecta");
                    break;
            }

        } while (!opcio.equalsIgnoreCase(
                "X"));
    }
}
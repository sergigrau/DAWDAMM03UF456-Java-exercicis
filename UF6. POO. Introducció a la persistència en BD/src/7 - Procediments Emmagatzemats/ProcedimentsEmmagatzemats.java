import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Classe que demostra el funcionament de la crida a procediments emmagatzemats de MySQL
 * Podem provar-ho directament amb call ALUMNES_PER_NOTA(5, @nota); select @nota;
 * @author sergi grau (sergi.grau@fje.edu)
 * @version 1.0 18.02.2014
 */
public class ProcedimentsEmmagatzemats {

    private static Connection conn;

    public static void main(String args[]) {

        BDAccessor bd = new BDAccessor();
        try {
            conn = bd.obtenirConnexio();

            //opcional
            crearProcedimentEmmagatzemat();

            Scanner entrada = new Scanner(System.in);
            float nota = entrada.nextFloat();

            int nombre = executarProcediementEmmagatzemat(nota);
            System.out.println("nombre de alumnes:" + nombre);

        } catch (ClassNotFoundException | IOException | SQLException ex) {

            ex.printStackTrace();
        }

    }

    public static void crearProcedimentEmmagatzemat() throws SQLException {
        String procediment = null;

        String drop =
                "DROP PROCEDURE IF EXISTS ALUMNES_PER_NOTA";

        procediment =
                "create procedure ALUMNES_PER_NOTA("
                + "IN n DECIMAL, "
                + "OUT nombre INTEGER) "
                + "begin "
                + "select count(nota) into "
                + "nombre "
                + "from alumneAutoinc "
                + "where nota > "
                + "n; "
                + "select nombre; "
                + "end";
        Statement stmt = null;
        Statement stmtDrop = null;

        try {
            System.out.println("cridant DROP PROCEDURE");
            stmtDrop = conn.createStatement();
            stmtDrop.execute(drop);
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } finally {
            if (stmtDrop != null) {
                stmtDrop.close();
            }
        }

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(procediment);
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * Mètode que retorna el nombre d'alumnes per sobre d'una determinada nota
     *
     * @param nota
     */
    public static int executarProcediementEmmagatzemat(Float nota) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call ALUMNES_PER_NOTA(?, ?)}");
        cs.setFloat(1, nota);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.executeQuery();

        return cs.getInt(2);
    }
}

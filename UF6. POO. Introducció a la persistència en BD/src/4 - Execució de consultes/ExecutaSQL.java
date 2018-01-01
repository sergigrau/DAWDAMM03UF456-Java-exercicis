import java.io.*;
import java.util.*;
import java.sql.*;

/**
 * Classe que executa sentències SQL introduïdes per l'entrada estàndard o 
 * definides en un fitxer
 *
 * @author sergi grau
 * @version 1.0 6.02.2012
 */
public class ExecutaSQL {

    public static void main(String args[]) {
        try {
            Scanner entrada;
            if (args.length == 0) {
                entrada = new Scanner(System.in);
            } else {
                entrada = new Scanner(new File(args[0]));
            }
            try (Connection conn = obtenirConnexio()) {
                Statement stat = conn.createStatement();

                while (true) {
                    if (args.length == 0) {
                        System.out.println("Entra sentencia SQL o SORTIR");
                    }

                    if (!entrada.hasNextLine()) {
                        return;
                    }

                    String linia = entrada.nextLine();
                    if (linia.equalsIgnoreCase("SORTIR")) {
                        return;
                    }
                    if (linia.trim().endsWith(";")) // elimina el ;
                    {
                        linia = linia.trim();
                        linia = linia.substring(0, linia.length() - 1);
                    }
                    try {
                        boolean teResultSet = stat.execute(linia);
                        if (teResultSet) {
                            mostrarResultSet(stat);
                        }
                    } catch (SQLException ex) {
                        for (Throwable e : ex) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Relitza una connexió a la BD, a partir de les propietats especificades en
     * un fitxer database.properties
     *
     * @return la connexió amb la BD
     */
    public static Connection obtenirConnexio() throws SQLException, IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/src/exercicis/database.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String usuari = props.getProperty("jdbc.username");
        String contrasenya = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, usuari, contrasenya);
    }

    /**
     * Mostra el ResultSet
     *
     * @param stat l'objecte Statment que volem printar
     */
    public static void mostrarResultSet(Statement stmt) throws SQLException {
        ResultSet resultat = stmt.getResultSet();
        ResultSetMetaData metaData = resultat.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            if (i > 1) {
                System.out.print(", ");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (resultat.next()) {
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) {
                    System.out.print(", ");
                }
                System.out.print(resultat.getString(i));
            }
            System.out.println();
        }
        resultat.close();
    }
}
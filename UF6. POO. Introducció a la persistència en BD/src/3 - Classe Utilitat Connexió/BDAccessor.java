import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Classe d'Utilitat per al manegament de la connexió a la Base de dades. Sempre connecta a un SGBD MySQL i en
 * conseqüència no fem servir la clau Driver del fixter de propietats
 *
 * @author sergi grau
 * @version 1.0, 05.02.2012
 */
public class BDAccessor {

    private String url = null;
    private String usuari = null;
    private String contrasenya = null;

    /**
     * Constructor per defecte
     */
    public BDAccessor() {
    }

    /**
     * Constructor amb tots els paràmetres.
     *
     * @param url
     * @param usuari
     * @param password
     *
     */
    public BDAccessor(String url, String usuari,
            String contrasenya) {
        this.url = url;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    /**
     * Obté una connexió de la BD. Primer de tot llegeix el fitxer de configuració (database.properties).
     *
     * @return La connexió a la BD.
     * @throws IOException Si no troba el fitxer de paràmetres de la connexió
     * @throws SQLException Si no pot obtenir la connexió a BD.
     * @throws ClassNotFoundException Si no troba la classe del driver de BD
     */
    public Connection obtenirConnexio() throws SQLException, IOException,
            ClassNotFoundException {

        Connection conn = null;
        // Llegeix el fitxer de configuració de la BD o els paramètres del constructor.
        try {
            assignarPropietatsBD();
        } catch (IOException ex) {
            System.err.println("ERROR: No s'ha pogut llegir el fitxer de parametres");
        }

        // Càrrega manual del driver no fem servir el contingut al fitxer de propietats
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: No s'ha pogut carregar el driver JDBC");
            throw ex;
        }

        // Connexió
        try {
            conn = DriverManager.getConnection(url, usuari, contrasenya);
            System.out.println("connexió efectuada");
        } catch (SQLException e) {
            System.err.println("ERROR: No s'ha pogut connectar amb el SGBD");
            throw e;
        }

        conn.setAutoCommit(false);

        return conn;
    }

    /**
     * Tanca la connexió a la BD.
     *
     * @param conn Connexió a la BD.
     */
    public static void tancarConnexio(Connection conn) {


        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error tancant la connexio a la BD");
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    /**
     * Tanca el PreparedStatement si encara està obert.
     *
     * @param pstmt
     */
    public static void tancarPreparedStatement(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                System.err.println("Error en tancar el PreparedStatement");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Llegeix un fitxer de propietats i el retorna en un objecte Properties
     *
     * @param fitxer Nom del fitxer de propietats
     * @return Properties Objecte propietats carregat amb els continguts del fitxer
     * @throws IOException Si no troba el fitxer
     */
    private static Properties carregarParametres(String fitxer) throws IOException {

        Properties propietats = new Properties();
        try (FileInputStream fitxerEntrada = new FileInputStream(fitxer)) {
            propietats.load(fitxerEntrada);
        }
        return propietats;
    }

    /**
     * Carrega el fitxer de propietats de la BD i les assigna als atributs de la classe.
     *
     * @throws IOException Si no llegeix el fitxer de configuració.
     */
    private void assignarPropietatsBD() throws IOException {
        // Obtenim la configuració de la base de dades
        Properties propietats = null;
        try {
            propietats = carregarParametres(System.getProperty("user.dir") + "/src/exercicis/database.properties");
            url = propietats.getProperty("jdbc.url");
            usuari = propietats.getProperty("jdbc.username");
            contrasenya = propietats.getProperty("jdbc.password");
        } catch (IOException e) {
            //els valors del constructor
            System.err.println("No s'ha trobat el fitxer basedades.properties");
            throw e;
        }
    }

    /*
     * Mètode principal per a efectuar un joc de proves
     */
    public static void main(String[] args) {
        //BDAccessor bd = new BDAccessor("jdbc:mysql://localhost:3306/daw2","root","root");
        BDAccessor bd = new BDAccessor();
        
        try (Connection conn = bd.obtenirConnexio()){
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}

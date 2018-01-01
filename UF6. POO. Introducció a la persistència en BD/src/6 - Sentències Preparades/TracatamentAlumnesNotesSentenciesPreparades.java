/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
Classe que realitza operacions sobre una taula Alumne. Utilitza una classe d'utilitat per a gestionar la connexió a
 * la BD i els camps són autonumèrics. Utilitza Sentències preparades
 *
 * @author sergi grau
 * @version 1.0 14.02.2012
 */
public class TracatamentAlumnesNotesSentenciesPreparades {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static BDAccessor bd= null;

    public static void main(String args[])  {

        bd  = new BDAccessor();
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
                       BDAccessor.tancarPreparedStatement(pstmt);
                       BDAccessor.tancarConnexio(conn);
                    break;
                default:
                    System.out.println("opció incorrecta");
                    break;
            }
        } while (opcio != 4);
    }

    public static void afegirAlumne(String nom, float nota) throws SQLException {
        try {
            String cadenaSQL = "INSERT INTO alumneAutoinc(nom,nota) VALUES(?,?)";
            pstmt = conn.prepareStatement(cadenaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, nom);
            pstmt.setFloat(2, nota);
            
            int n = pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                while (rs.next()) {
                    System.out.println("Codi generat per getGeneratedKeys():"
                            + rs.getInt(1));
                }
            }
            System.out.println("S'ha afegit " + n + " items");

        } finally {
            pstmt.clearParameters();
        }
    }

    /**
     * Mètode que mostra tots els alumnes
     *
     * @throws SQLException
     */
    public static void consultarAlumnes() throws SQLException {

        try {
            String cadenaSQL= "SELECT * FROM alumneAutoinc";
            pstmt = conn.prepareStatement(cadenaSQL);
            try (ResultSet resultat = pstmt.executeQuery()) {
                while (resultat.next()) {
                    System.out.println(resultat.getInt(1)
                            + "-" + resultat.getString(2)
                            + "-" + resultat.getString(3));
                }
            }
            
        } finally {
        }
    }
    /*
     * Mostra tots els alumnes amb una nota major a nota
     */

    public static void consultarAlumnes(String nota) throws SQLException {

        try {
            String cadenaSQL= "SELECT * FROM alumneAutoinc WHERE nota > ?";
            pstmt = conn.prepareStatement(cadenaSQL);
            pstmt.setFloat(1, Float.parseFloat(nota));
            
            try (ResultSet resultat = pstmt.executeQuery()) {
                while (resultat.next()) {
                    System.out.println(resultat.getInt(1)
                            + "-" + resultat.getString(2)
                            + "-" + resultat.getString(3));
                }
            }

        } finally {
             pstmt.clearParameters();
        }
    }

    
}
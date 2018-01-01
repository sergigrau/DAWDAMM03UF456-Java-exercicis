import java.util.Date;
import javax.persistence.*;


/** 
 * Classe principal que crea diverses instàncies d'una jerarquia d'herència
 * i fa el mapatge de l'herència
 * @author sergi grau
 * @version 1.0 10.04.2013
 */
public class CreaEntitats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ServeiEmpleat");
        EntityManager em = emf.createEntityManager();

        ServeiEmpleatExtern servei = new ServeiEmpleatExtern(em);
        em.getTransaction().begin();
        Empleat emp = servei.crearEmpleat(1, "sergi", new Date());
        ((EmpleatExtern)emp).setCostDiari(10);
        //Empleat emp2 = servei.crearEmpleat(2, "joan", new Date());  
        //servei.esborrarEmpleat(1);   
        em.getTransaction().commit();

    }
}

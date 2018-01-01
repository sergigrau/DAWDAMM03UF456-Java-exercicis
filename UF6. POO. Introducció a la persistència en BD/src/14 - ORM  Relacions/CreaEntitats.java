import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author sergi grau
 */
public class CreaEntitats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ServeiEmpleat");
        EntityManager em = emf.createEntityManager();
        ServeiEmpleat se = new ServeiEmpleat(em);
        ServeiDepartament sd = new ServeiDepartament(em);
        ServeiAparcament sa = new ServeiAparcament(em);

        em.getTransaction().begin();
        Empleat emp = se.crearEmpleat("sergi", 1000);
        
        Departament dep = sd.crearDepartament("informàtica");
        emp.setDepartament(dep);
        
        Aparcament ap = sa.crearAparcament("507");
        emp.setAparcament(ap);
        
        em.getTransaction().commit();
        System.out.println("s'ha fet persistent " + emp);

    }
}

import java.util.ArrayList;
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
        Empleat emp1 = se.crearEmpleat("sergi", 1000);
        Empleat emp2 = se.crearEmpleat("joan", 2000);
        
        Departament dep = sd.crearDepartament("informàtica");
        
        emp1.setDepartament(dep);
        emp2.setDepartament(dep);
        
        dep.setEmpleats(new ArrayList<Empleat>());
        dep.getEmpleats().add(emp1);
        dep.getEmpleats().add(emp2);
        
        Aparcament ap = sa.crearAparcament("507");
        emp1.setAparcament(ap);
        emp2.setAparcament(ap);
        
        em.getTransaction().commit();
        System.out.println("s'ha fet persistent " + emp1);
         System.out.println("s'ha fet persistent " + emp2);

         System.out.println("treballadors del departament " + dep.getNom());
         for(Empleat e: dep.getEmpleats()){
             System.out.println(e);
         }

    }
}

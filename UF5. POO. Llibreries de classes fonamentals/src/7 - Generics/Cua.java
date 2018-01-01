import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Classe que representa una cua mitjançant classes genèriques
 * @author sergi grau
 * @version 1.0 27.01.2014
 */
public class Cua<E>  {

    public static final int MAXIM_ELEMENTS_PER_DEFECTE = 256;
    protected E[] elements;
    protected int n;
    private int primer;

    public Cua() {
        this(MAXIM_ELEMENTS_PER_DEFECTE);
    }

    public Cua(int max) {
        elements = (E[]) new Object[max];
        n = 0;
        primer = 0;
    }

    private int posicio(int posicio) {
        return posicio % elements.length;
    }

    private int seguent(int posicio) {
        return (posicio + 1) == elements.length ? 0 : posicio + 1;
    }

    public void encuar(E elem) {
        int darrer = posicio(primer + n);
        elements[darrer] = elem;
        n++;
    }

    public E desencuar() {
        E elem = elements[primer];
        elements[primer] = null;
        primer = seguent(primer);
        n--;
        return elem;
    }

    

    public static void main(String[] args){
        Cua<String> cua = new Cua<>();
        cua.encuar("sergi");
        cua.encuar("joan");
        cua.encuar("carles");
        System.out.println(cua.desencuar());
        System.out.println(cua.desencuar());
        
    }
}
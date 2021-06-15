package dennis;/*import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Method;
import java.util.ArrayList;*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class category_m <E>{

    String id ="";

    static Function<Object , Object> identity_function = category_m::identity;
    public static morphism identity = new morphism(identity_function, "identity", 000, 000 );

    public ArrayList<element<E>> element_list = new ArrayList<>(); /* Arraylist of element in the category */
    public ArrayList<morphism> morphism_list = new ArrayList<morphism>(Arrays.asList(identity)); /* Arraylist of morphism of the category */

    public static morphism compose(morphism f1,morphism f2){
        return new morphism(f1.Funzione.andThen(f2.Funzione),"composedfunction",f1.domain, f2.codomain);
    }

    public void add_morphism (morphism m) {
        morphism_list.add(m);
    }

    /*
    *  Various method
    */

    public  void add(element<E> i){
        this.element_list.add(i);
    }

    public void add(E i){
        element<E> el = new element<>(i);
        add(el);
    }

    public element<E> pop(E i){
        for(int a=0;a<element_list.size();a++){
            if(element_list.get(a).value==i){
                element<E> b =new element<>(i);
                element_list.remove(a);
                return b;
            }
        }
        return new element<>();
    }

    public element<E> get(E i){
        for (element<E> eelement : element_list) {
            if (eelement.value == i) {
                return eelement;
            }
        }
        return new element<>();
    }

    public static <I> I identity(I i) { return i; }
}
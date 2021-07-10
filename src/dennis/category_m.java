package dennis;/*import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Method;
import java.util.ArrayList;*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class category_m <E> {

    String id ="";

    static Function<Object , Object> identity_function = category_m::identity;
    public static morphism identity = new morphism(identity_function, "identity", "object", "object" );

    public ArrayList<element<E>> element_list = new ArrayList<>(); /* Arraylist of element in the category */
    public ArrayList<morphism> morphism_list = new ArrayList<morphism>(Arrays.asList(identity)); /* Arraylist of morphism of the category */


    public morphism compose(morphism f1,morphism f2) throws IllegalCompositionError{
        if (f1.codomain != f2.domain) {
            throw new IllegalCompositionError();
        }
        morphism m = new morphism(f1.Funzione.andThen(f2.Funzione),f1.nome+"_"+f2.nome, f1.domain, f2.codomain);
        morphism_list.add( m );
        return m;
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


    public morphism call_morphism(String s){

        //call_morphism serve a chiamare il morphism su un altro object. Il morphism continua a comparire
        //una sola volta in morphism_list

        morphism m=new morphism();
        for (int i=0;i<morphism_list.size();i++){
            String name=morphism_list.get(i).nome;
            if (name.equals(s)){
                System.out.println("here");
                m=morphism_list.get(i);
            }
        }
        return m;

    }

    //E risultato -- input deve essere uguale all'output
    public boolean is_inverse(morphism m1,morphism m2,E risultato){
        return true;

    }
}
package ema;

import dennis.category_m;
import dennis.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class category_general<E>{

    String id ="";

    static Function<Object , Object> identity_function = category_m::identity;
    public static morphism_ema identity = new morphism_ema(identity_function, "identity", 000, 000 );

    public ArrayList<element<E>> element_list = new ArrayList<>(); /* Arraylist of element in the category */
    public ArrayList<morphism_ema> morphism_list = new ArrayList<morphism_ema>(Arrays.asList(identity)); /* Arraylist of morphism of the category */


    /*
     *  Various method
     */

    public void compose(morphism_ema f1,morphism_ema f2){
        morphism_ema m = new morphism_ema(f1.Funzione.andThen(f2.Funzione),f1.nome+"_"+f2.nome, f1.domain, f2.codomain);
        morphism_list.add( m );
    }
    public void add_morphism (morphism_ema m) {
        morphism_list.add(m);
    }

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

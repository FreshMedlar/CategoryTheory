package ema;

import dennis.element;

import java.util.ArrayList;
import java.util.function.Function;

public abstract class abstract_category <E>{

    String id ="";

    public ArrayList<element<E>> element_list = new ArrayList<element<E>>();

    public static Function compose(Function f1,Function f2){
        f1=f1.andThen(f2);
        return f1 ;
    }

    public  void add(element i){
        this.element_list.add(i);
    }

    public void add(E i){
        element<E> el = new element<E>(i);
        add(el);
    }

    public element get(E i){
        for(int a=0;a<element_list.size();a++){
            if(element_list.get(a).value==i){
                element b =new element(i);
                element_list.remove(a);
                return b;
            }
        }
        return new element();
    }
}
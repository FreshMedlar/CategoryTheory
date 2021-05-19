package dennis;/*import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Method;
import java.util.ArrayList;*/
import java.util.ArrayList;

public abstract class category_m <E>{
    String id ="";
    public ArrayList<element<E>> element_list = new ArrayList<>();
    public static morphism compose(morphism f1,morphism f2){
     return new morphism(f1.Funzione.andThen(f2.Funzione),"composedfunction",f1.IDI, f2.IDO)  ;
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
}
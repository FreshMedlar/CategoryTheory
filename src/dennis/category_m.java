package dennis;/*import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Method;
import java.util.ArrayList;*/
import java.util.ArrayList;
import java.util.function.Function;

public abstract class category_m <E>{
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
}
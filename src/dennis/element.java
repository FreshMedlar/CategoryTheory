package dennis;

import java.lang.reflect.Type;


public class element <E> {
    public E  value;
    public element(E eleme){
        value=eleme;
    }
    public String toString(){
        return(""+value);
    }
}
package dennis;
public class element <E> {
    public E  value;
    public element(){}
    public element(E eleme){
        value=eleme;
    }
    public String toString(){
        return(""+value);
    }
}
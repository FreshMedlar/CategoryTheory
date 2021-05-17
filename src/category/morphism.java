package category;

import java.lang.*;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.lang.reflect.Type;

public class morphism{

    /*
     String input= new CI();
     String output= new String();
     O funzione(I i);
     */
    String input =new String();
    String output = new String();
    String name = new String();
    Method funzione;
    public morphism(String nam, String inpu, String outpu, Method funz) {
        Method funzione = funz;
        String input = inpu;
        String output = outpu;
        String name = nam;

    }
}


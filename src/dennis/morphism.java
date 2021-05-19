package dennis;

import java.util.function.Function;

public class morphism {
    Function Funzione;
    String nome;
    int IDI;
    int IDO;
    public morphism(Function f1,String n,int input,int outputu){
        nome=n;
        Funzione=f1;
        IDI=input;
        IDO=input;
    }
}

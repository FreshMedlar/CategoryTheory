package dennis;

import java.util.function.Function;

public class morphism {
    Function Funzione;
    public String nome;
    int domain;
    int codomain;

    public morphism(Function f1,String n,int domain,int codomain){
        nome=n;
        Funzione=f1;
        this.domain=domain;
        this.codomain=codomain;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' ;
    }
}

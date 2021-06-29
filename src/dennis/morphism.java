package dennis;

import java.util.function.Function;

public class morphism {
    Function Funzione;
    public String nome;
    String domain;
    String codomain;

    public morphism(Function f1,String n,String domain,String codomain){
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

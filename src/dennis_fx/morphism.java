package dennis_fx;

import java.util.function.Function;

public class morphism {
    Function Funzione;
     String nome;
    String domain;
    String codomain;
    public Function getFunzione(){
        return Funzione;
    }
    public morphism(Function f1,String n,String domain,String codomain){
        nome=n;
        Funzione=f1;
        this.domain=domain;
        this.codomain=codomain;
    }

    public morphism(){}
    public static morphism morphism_copy(morphism a){
        return new morphism(a.Funzione,a.nome,a.domain,a.codomain);
    }
    @Override
    public String toString() {
        return "nome='" + nome + '\'' ;
    }
}

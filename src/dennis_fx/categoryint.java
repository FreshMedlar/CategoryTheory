package dennis_fx;

import java.util.ArrayList;
import java.util.function.*;

//import java.lang.reflect.*;
public class categoryint  extends category_m{

    public categoryint(){
    }
    public categoryint(ArrayList<element<Integer>> elem, String n){
        element_list=elem;
        id =n;
        identity.codomain="integer";
        identity.domain="integer";
        morphism_list.add(factorial_m);
        System.out.println("adding");
        morphism_list.add(squareroot_rounded_m);
        morphism_list.add(successor_m);
        morphism_list.add(predecessor_m);
    }

    static Function<Integer, Integer> factorial_function = categoryint::factorial;
    static Function<Integer,Integer> root_function= categoryint::squareroot_rounded;
    static Function<Integer,Integer> successor_function= categoryint::successor;
    static Function<Integer,Integer> predecessor_function=categoryint::predecessor;

    public static morphism factorial_m=new morphism(factorial_function,"factorial","integer","integer");
    public static morphism squareroot_rounded_m=new morphism(root_function,"squareroot","integer","integer");
    public static morphism successor_m=new morphism(successor_function,"successor","integer","integer");
    public static morphism predecessor_m=new morphism(predecessor_function,"predecessor","integer","integer");


    //    void print() {
    //         for (Object o : element_list) {
    //             System.out.print(o + "\n");
    //         }
    //    }

    public String toString() {
        StringBuilder s= new StringBuilder();
        for (Object o : element_list) {
            s.append(o).append("\n");
        }
        s.append("Morphisms : ");
        for (int i=0; i<morphism_list.size(); i++) {

            Object curr = morphism_list.get(i);

            s.append(curr).append("\n");
        }
        return s.toString();
    }

    static int successor (int n){return (n+1);}

    static int predecessor (int n){return (Integer)(n-1);}

    static  int  squareroot_rounded(int N){
        return (int) (Math.round(Math.sqrt(N)*1)/1);
    }

    static int factorial(int n){
        int res=1;
        for (int i=1;i<n+1;i++){
            res=res*i;
        }
        return res;
    }

}

package dennis;

import java.util.ArrayList;
import java.util.function.*;

//import java.lang.reflect.*;
class categoryint  extends category_m{

    static Function<Integer, Integer> factorial_function = categoryint::factorial;
    Function<Integer,Float> root_function= categoryint::squareroot;
    morphism factorial=new morphism(factorial_function,"factorial",001,001) ;
    morphism squareroot=new morphism(root_function,"root_function",001,001) ;

    public categoryint(){
    }
    public categoryint(ArrayList<element<Integer>> elem, String n){
        element_list=new ArrayList<element<Integer>>();
        element_list=elem;
        id =n;
    }

     void print() {
         for (Object o : element_list) {
             System.out.print(o + "\n");
         }
     }
    public String toString() {
        StringBuilder s= new StringBuilder();
        for (Object o : element_list) {
            s.append(o).append("\n");
        }
        return s.toString();
    }
    static  float squareroot(int N){
        return (float) Math.sqrt(N);
    }
    static int factorial(int n){
            int res=1;
           for (int i=1;i<n+1;i++){
               res=res*i;
           }
           return res;
    }
}

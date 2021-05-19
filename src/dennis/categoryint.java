package dennis;

import java.util.ArrayList;
import java.util.function.*;

//import java.lang.reflect.*;
class categoryint  extends category_m{
    static Function<Integer, Integer> factorial_function = a->factorial(a);
     Function<Integer,Float> root_function=a->squareroot(a);
    public categoryint(){
    }
    public categoryint(ArrayList<element<Integer>> elem, String n){
        element_list=new ArrayList<element<Integer>>();
        element_list=elem;
        id =n;
    }
     void print() {
         for (int i = 0; i < element_list.size(); i++) {
             System.out.print(element_list.get(i) + "\n");
         }
     }
    public String toString() {
        String s="";
        for (int i = 0; i < element_list.size(); i++){
            s=s+element_list.get(i)+"\n";
        }
        return s;
    }
    static  float squareroot(int N){
        float a = (float) Math.sqrt(N);
        return a ;
    }
    static int factorial(int n){
            int res=1;
           for (int i=1;i<n;i++){
               res=res*i;
           }
           return res;
    }
}

package dennis;


import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<element<Integer>> uno = new ArrayList<>();
        uno.add(new element<>(1));
        categoryint a=new categoryint(uno, "interi");
        a.add(10);
        System.out.println(a.morphism_list);
        a.compose(categoryint.factorial_m, categoryint.squareroot_m);
        System.out.println(a.morphism_list);
        a.compose(categoryint.factorial_m, categoryString.bold);

//        System.out.println(a);
        categoryString v = new categoryString();
        System.out.println(v.morphism_list);

//        a.add(1);
//        morphism f1=category_m.compose(a.id,a.id);
//        a.add(a.factorial_function.apply(4));
//        a.add(f1.Funzione.apply(5));
//        System.out.println(a.pop(24));
//        System.out.println(a);


    }
}

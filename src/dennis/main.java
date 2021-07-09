package dennis;


import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<element<String>> stringhe = new ArrayList<>();
        stringhe.add(new element<>("ciao"));
        categoryString strings =new categoryString(stringhe,"strings");
        System.out.println(strings.morphism_list);
        System.out.println(strings.count_letters("CIAO"));
        System.out.println(strings.duplicate("ciao"));
        System.out.println(strings.bold("ciao"));
        System.out.println(strings.compose(strings.duplicate,strings.count_letters).Funzione.apply("ciao"));
        //System.out.println(strings.compose(strings.duplicate,strings.count_letters).Funzione.apply("ciao"));
        System.out.println(strings.morphism_list);
        System.out.println(strings.call_morphism("duplicate_count_letters").Funzione.apply("fiore"));
        //System.out.println(strings.duplicate.Funzione.apply("ciao"));
        //strings.call_morphism("duplicate_count_letters");








        /*ArrayList<element<Integer>> uno = new ArrayList<>();
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

         */




    }
}

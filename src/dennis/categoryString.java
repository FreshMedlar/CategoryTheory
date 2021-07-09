package dennis;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;

public class categoryString extends category_m {

    public categoryString() {
    }
    public categoryString(ArrayList<element<String>> elem, String n) {
        element_list = new ArrayList<element<String>>();
        element_list = elem;
        id = n;
        morphism_list.add(bold);
        morphism_list.add(duplicate);
        morphism_list.add(count_letters);
    }

    static Function<String, String> bold_function = categoryString::bold;

    public static morphism bold = new morphism(bold_function, "bold", "string", "string");

    static String duplicate (String s) {
        s = s + s;
        return s;
    }

    static Function<String,String> duplicate_function= categoryString::duplicate;

    public static morphism duplicate= new morphism(duplicate_function,"duplicate","string","string");



    static String bold (String s){
        return s.toUpperCase();
    }

    //int counter=0;
    static Integer count_letters (String s){
        //int counter=s.length();
        return s.length();
    }

    static Function<String,Integer> count_letters_function= categoryString::count_letters;

    public static morphism count_letters=new morphism(count_letters_function,"count_letters","string","integer");


}

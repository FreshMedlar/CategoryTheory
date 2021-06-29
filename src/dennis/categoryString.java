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
    }

    static Function<String, String> bold_function = categoryString::bold;

    public static morphism bold = new morphism(bold_function, "bold", "string", "string");

    static String duplicate (String s) {
        s = s + s;
        return s;
    }
    static String bold (String s){
        return s.toUpperCase();
    }

}

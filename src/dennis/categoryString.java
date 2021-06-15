package dennis;

import java.util.ArrayList;

public class categoryString extends category_m {

    public categoryString() {
    }

    public categoryString(ArrayList<element<String>> elem, String n) {
        element_list = new ArrayList<element<String>>();
        element_list = elem;
        id = n;
    }

    static String duplicate (String s) {
        s = s + s;
        return s;
    }

}

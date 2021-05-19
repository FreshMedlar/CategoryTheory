package dennis;

import java.util.function.Function;

public class main {
    public static void main(String[] args) {
        categoryint a=new categoryint();
        a.add(1);
        Function<Object,Object> f1=category_m.compose(a.factorial_function,a.root_function);
        a.add(f1.apply(10));
        a.add(a.factorial_function.apply(4));
        System.out.println(a);
    }
}

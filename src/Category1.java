import org.jetbrains.annotations.Contract;

import java.util.Locale;
import java.util.function.Function;

public class Category1 {

    @Contract(pure = true)
    public static <T> Function<T, T> identity() {
        return (T t) -> t;
    };

    public static <A, B, C> Function<A, C> compose(Function<A, B> f, Function<B, C> g) {
        return (A a) -> g.apply(f.apply(a));
    }




    public static void main(String[] args) {
        String a = "ciao";
        a = a.toUpperCase(Locale.ROOT);

        System.out.println(identity().apply(3));

        System.out.println(compose( String::length , Integer::toBinaryString ).apply("ciao"));

    }
}

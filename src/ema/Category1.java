package ema;


//
//import java.util.Locale;
//import java.util.function.Function;
//
//public class Category1 {
//
//
//    public static <T> Function<T, T> identity() {
//        return (T t) -> t;
//    };
//
//    public static <A, B, C> Function<A, C> compose(Function<A, B> f, Function<B, C> g) {
//        return (A a) -> g.apply(f.apply(a));
//    }
//
//
//
//
//    public static void main(String[] args) {
//        String a = "ciao";
//        a = a.toUpperCase(Locale.ROOT);
//        Integer b = 10;
//        System.out.println(identity().apply(3));
//        System.out.println(compose( identity(), Integer::toBinaryString).apply(10));
////        System.out.println(compose( String::length , Integer::toBinaryString ).apply("ciaao"));
//
//    }
//}

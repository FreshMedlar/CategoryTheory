import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;

public class Main {

    public static <T> T id(T obj) {
        return obj;
    }

    @Contract(pure = true)
    public static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return obj -> g.apply(f.apply(obj));
    }

    public static void main(String[] args) {
        System.out.println("1 == id 1 : " + (1 == id(1)));

        Integer number = 100;

        System.out.println("id . toString == toString : " +
                Objects.equals(compose(Main::id, Object::toString).apply(number), number.toString()));

        System.out.println("toString . id == toString : " +
                Objects.equals(compose(Object::toString, Main::id).apply(number), number.toString()));
    }
}
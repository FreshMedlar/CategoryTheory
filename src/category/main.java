package category;

public class main {
    public static void main(String[] args) {
        Class<?> C  = (new Category()).getClass();
        System.out.println(C.getDeclaredMethods());
    }
}

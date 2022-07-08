import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Java 11");

        System.out.println("New Features in Java 11:");

        StringJoiner sj = new StringJoiner(", ", "[ ", " ]");

        sj.add("New String features");
        sj.add("File Methods");
        sj.add("Collections to array");
        sj.add("var: local variables");
        sj.add("Not Predicate");
        sj.add("Directly run Java file");

        String java11Features = sj.toString();
        System.out.println(java11Features);
    }
}
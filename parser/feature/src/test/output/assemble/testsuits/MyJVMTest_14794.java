import java.util.HashSet;
import java.util.Set;

public class MyJVMTest_14794 {

    static String string = "5X^y]4_40Q";

    static Set<String> acceptedStrings = new HashSet<>();

    boolean accept(String string) {
        return acceptedStrings.contains(string);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14794().accept(string));
    }
}

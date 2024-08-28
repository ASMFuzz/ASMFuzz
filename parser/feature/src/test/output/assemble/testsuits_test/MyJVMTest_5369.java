import java.util.HashSet;
import java.util.Set;

public class MyJVMTest_5369 {

    static String string = "mCefGh&)4P";

    static Set<String> acceptedStrings = new HashSet<>();

    boolean accept(String string) {
        return acceptedStrings.contains(string);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5369().accept(string));
    }
}

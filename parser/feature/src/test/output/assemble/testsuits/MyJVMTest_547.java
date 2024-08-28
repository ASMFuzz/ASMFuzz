import java.util.ArrayList;

public class MyJVMTest_547 {

    static String s = "KfRB9S1tt\"";

    static ArrayList<String> disabledRuntimePrefixes = new ArrayList<>();

    String disableRuntimePrefix(String s) {
        disabledRuntimePrefixes.add(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_547().disableRuntimePrefix(s);
    }
}

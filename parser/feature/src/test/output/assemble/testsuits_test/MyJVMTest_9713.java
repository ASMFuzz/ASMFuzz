import java.util.ArrayList;

public class MyJVMTest_9713 {

    static String s = "t6q<\"zzgF2";

    static ArrayList<String> disabledRuntimePrefixes = new ArrayList<>();

    String disableRuntimePrefix(String s) {
        disabledRuntimePrefixes.add(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9713().disableRuntimePrefix(s);
    }
}

import java.util.ArrayList;

public class MyJVMTest_9019 {

    static String s = "KKB_G#XzWF";

    static ArrayList<String> disabledRuntimePrefixes = new ArrayList<>();

    String disableRuntimePrefix(String s) {
        disabledRuntimePrefixes.add(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9019().disableRuntimePrefix(s);
    }
}

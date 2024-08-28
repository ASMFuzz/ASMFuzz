import jdk.nashorn.internal.runtime.Undefined;

public class MyJVMTest_16591 {

    static Undefined x = null;

    static String w = "votpmPGc&:";

    String inspect(final Undefined x, final String w) {
        return w + ": undefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16591().inspect(x, w));
    }
}

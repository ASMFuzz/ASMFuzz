import jdk.nashorn.internal.runtime.Undefined;

public class MyJVMTest_7073 {

    static Undefined x = null;

    static String w = "YKw R!4}ho";

    String inspect(final Undefined x, final String w) {
        return w + ": undefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7073().inspect(x, w));
    }
}

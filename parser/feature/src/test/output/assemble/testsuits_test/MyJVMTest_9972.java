import java.util.Arrays;

public class MyJVMTest_9972 {

    static String what = "K{cIR4ux,l";

    static Object v = 0;

    static Object[] ref = { 2, -1529814584, 0, 8, 0, 0, 4, 9, 5, 0 };

    String checkEnumEq(String what, Object v, Object[] ref) throws Exception {
        if (v == null) {
            throw new Exception("null " + what);
        }
        if (!(v instanceof Object[])) {
            throw new Exception("invalid " + what);
        }
        if (Arrays.equals((Object[]) v, ref)) {
            System.out.println(what + ": ok");
        } else {
            throw new Exception("invalid " + what);
        }
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9972().checkEnumEq(what, v, ref);
    }
}

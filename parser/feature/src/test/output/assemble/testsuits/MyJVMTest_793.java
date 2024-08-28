import java.util.Arrays;

public class MyJVMTest_793 {

    static String what = "@:y\"Ahs8!Y";

    static Object v = -437166784;

    static Object[] ref = { 5, 4, 3, 502610295, 5, 0, -1990916331, 5, 0, 2 };

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
        new MyJVMTest_793().checkEnumEq(what, v, ref);
    }
}

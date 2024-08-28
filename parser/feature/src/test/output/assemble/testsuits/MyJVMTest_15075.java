public class MyJVMTest_15075 {

    static String what = "3+S(!Hw-n~";

    static Object v = 7;

    static Object ref = 0;

    Object checkEq(String what, Object v, Object ref) throws Exception {
        if ((v != null) && v.equals(ref)) {
            System.out.println(what + ": ok (" + ref.toString() + ")");
        } else {
            throw new Exception("invalid " + what + ", expected: \"" + ref + "\", got: \"" + v + "\"");
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15075().checkEq(what, v, ref);
    }
}

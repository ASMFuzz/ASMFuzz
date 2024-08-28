public class MyJVMTest_5639 {

    static String what = "F!+O>bH~=V";

    static Object v = 1310747938;

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
        new MyJVMTest_5639().checkEq(what, v, ref);
    }
}

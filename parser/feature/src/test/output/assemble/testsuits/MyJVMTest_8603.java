public class MyJVMTest_8603 {

    static String s = "f$|Yy2B1DB";

    boolean parseThrow(String s) {
        if (s.equals("true"))
            return true;
        if (s.equals("false"))
            return false;
        throw new RuntimeException("Unrecognized expectation: " + s);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8603().parseThrow(s));
    }
}

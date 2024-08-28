public class MyJVMTest_18195 {

    static String s = "?tg5mRQB7g";

    boolean parseThrow(String s) {
        if (s.equals("true"))
            return true;
        if (s.equals("false"))
            return false;
        throw new RuntimeException("Unrecognized expectation: " + s);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18195().parseThrow(s));
    }
}

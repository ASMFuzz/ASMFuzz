public class MyJVMTest_5528 {

    static String a = "A}}m<d#o0;";

    static String stringU = "\u0f21\u0f22\u0f23\u0f24\u0f25\u0f26\u0f27\u0f28";

    static String stringSmallU = "\u0f21\u0f22\u0f23";

    String concatStringConstU(String a) {
        return new StringBuilder().append(stringSmallU).append(a).append(stringU).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5528().concatStringConstU(a));
    }
}

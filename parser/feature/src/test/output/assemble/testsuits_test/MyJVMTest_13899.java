public class MyJVMTest_13899 {

    static int b = 610050861;

    static String stringU = "\u0f21\u0f22\u0f23\u0f24\u0f25\u0f26\u0f27\u0f28";

    static String stringSmallU = "\u0f21\u0f22\u0f23";

    static int constInt = 123;

    static int constIntNeg = -123;

    String concatIntConstU(int b) {
        return new StringBuilder().append(stringSmallU).append(b).append(stringU).append(constInt).append(constIntNeg).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13899().concatIntConstU(b));
    }
}

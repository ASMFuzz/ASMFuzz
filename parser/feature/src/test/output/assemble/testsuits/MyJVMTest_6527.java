public class MyJVMTest_6527 {

    static int b = 0;

    static String stringL = "abcdefghijklmnop";

    static String stringSmallL = "abc";

    static int constInt = 123;

    static int constIntNeg = -123;

    String concatIntConstL(int b) {
        return new StringBuilder().append(stringL).append(b).append(stringSmallL).append(constInt).append(constIntNeg).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6527().concatIntConstL(b));
    }
}

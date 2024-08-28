public class MyJVMTest_14648 {

    static String a = "CVa!F!*_R_";

    static String stringL = "abcdefghijklmnop";

    static String stringSmallL = "abc";

    String concatStringConstL(String a) {
        return new StringBuilder().append(stringL).append(a).append(stringSmallL).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14648().concatStringConstL(a));
    }
}

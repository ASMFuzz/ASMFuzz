public class MyJVMTest_5228 {

    static String a = "4Py.0cHO),";

    static String stringL = "abcdefghijklmnop";

    static String stringSmallL = "abc";

    String concatStringConstL(String a) {
        return new StringBuilder().append(stringL).append(a).append(stringSmallL).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5228().concatStringConstL(a));
    }
}

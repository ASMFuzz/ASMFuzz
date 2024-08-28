public class MyJVMTest_16870 {

    static String a = "o}2-4u]w?D";

    static String stringSmallL = "abc";

    String indexOfConstL(String a) {
        int result = a.indexOf(stringSmallL);
        return a.substring(result, result + stringSmallL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16870().indexOfConstL(a));
    }
}

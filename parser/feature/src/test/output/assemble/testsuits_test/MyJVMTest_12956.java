public class MyJVMTest_12956 {

    static String a = "#kjLynBNwc";

    static String stringL = "abcdefghijklmnop";

    String indexOfConstLargeUL(String a) {
        int result = a.indexOf(stringL);
        return a.substring(result, result + stringL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12956().indexOfConstLargeUL(a));
    }
}

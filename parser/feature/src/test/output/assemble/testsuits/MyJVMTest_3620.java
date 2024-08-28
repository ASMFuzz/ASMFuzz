public class MyJVMTest_3620 {

    static String a = "eVk?1N%3j3";

    static String stringL = "abcdefghijklmnop";

    String indexOfConstLargeUL(String a) {
        int result = a.indexOf(stringL);
        return a.substring(result, result + stringL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3620().indexOfConstLargeUL(a));
    }
}

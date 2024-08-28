public class MyJVMTest_3549 {

    static String a = "Yj'hYO~{u1";

    static String stringL = "abcdefghijklmnop";

    String indexOfConstLargeL(String a) {
        int result = a.indexOf(stringL);
        return a.substring(result, result + stringL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3549().indexOfConstLargeL(a));
    }
}

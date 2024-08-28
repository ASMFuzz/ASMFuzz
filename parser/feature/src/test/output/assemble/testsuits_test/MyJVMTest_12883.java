public class MyJVMTest_12883 {

    static String a = ";)?1&DyFYn";

    static String stringL = "abcdefghijklmnop";

    String indexOfConstLargeL(String a) {
        int result = a.indexOf(stringL);
        return a.substring(result, result + stringL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12883().indexOfConstLargeL(a));
    }
}

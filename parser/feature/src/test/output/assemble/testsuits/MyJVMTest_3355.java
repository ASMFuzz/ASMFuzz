public class MyJVMTest_3355 {

    static String message = "u$AnwhM1<f";

    static boolean lfMissing = false;

    String out1(String message) {
        System.out.print(message);
        lfMissing = true;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3355().out1(message);
    }
}

public class MyJVMTest_10290 {

    static String message = "t_'=}$0Cbv";

    static boolean lfMissing = false;

    String out(String message) {
        lfMissing = true;
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10290().out(message);
    }
}

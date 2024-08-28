public class MyJVMTest_5933 {

    static String message = "Z(a2NxGdxW";

    static boolean lfMissing = false;

    String out2(String message) {
        if (lfMissing) {
            System.out.println();
            lfMissing = false;
        }
        System.out.println("  " + message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5933().out2(message);
    }
}

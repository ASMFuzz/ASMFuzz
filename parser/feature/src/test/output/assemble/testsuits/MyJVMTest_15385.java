public class MyJVMTest_15385 {

    static String message = "GL)9#FXFK8";

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
        new MyJVMTest_15385().out2(message);
    }
}

public class MyJVMTest_12683 {

    static String message = "9;EdSoScDM";

    static boolean lfMissing = false;

    String out1(String message) {
        System.out.print(message);
        lfMissing = true;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12683().out1(message);
    }
}

public class MyJVMTest_1095 {

    static String message = "8gI&!^Y$`}";

    static boolean lfMissing = false;

    String out(String message) {
        lfMissing = true;
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1095().out(message);
    }
}

public class MyJVMTest_3504 {

    static String message = "dt>;qiMX~,";

    static boolean value = true;

    int test(String message, boolean value) {
        System.out.println(message + ": " + (value ? "passed" : "failed"));
        return value ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3504().test(message, value));
    }
}

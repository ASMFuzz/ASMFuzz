public class MyJVMTest_12838 {

    static String message = "Twi?mG3=[b";

    static boolean value = false;

    int test(String message, boolean value) {
        System.out.println(message + ": " + (value ? "passed" : "failed"));
        return value ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12838().test(message, value));
    }
}

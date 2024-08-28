public class MyJVMTest_3407 {

    void test() {
        s = s + toAdd;
    }

    static String toAdd = "0123456789abcdef";

    static int maxLength = 9;

    static String s = "h%@bVobzs5";

    void run() {
        do {
            test();
        } while (s.length() < maxLength);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3407().run();
    }
}

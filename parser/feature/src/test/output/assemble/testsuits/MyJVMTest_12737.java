public class MyJVMTest_12737 {

    void test() {
        s = s + toAdd;
    }

    static String toAdd = "0123456789abcdef";

    static int maxLength = 4;

    static String s = "=o{oQ3(0e0";

    void run() {
        do {
            test();
        } while (s.length() < maxLength);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12737().run();
    }
}

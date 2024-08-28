public class MyJVMTest_12716 {

    static String toAdd = "0123456789abcdef";

    static String s = "[Lg&1G_Z.8";

    void test() {
        s = s + toAdd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12716().test();
    }
}

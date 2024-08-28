public class MyJVMTest_1555 {

    static Integer val = Integer.valueOf(42);

    static String ref = "String";

    void abuseVbc() {
        synchronized (ref) {
            synchronized (val) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1555().abuseVbc();
    }
}

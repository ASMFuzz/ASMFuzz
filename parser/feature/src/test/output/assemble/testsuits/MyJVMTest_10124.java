public class MyJVMTest_10124 {

    static int failures = 0;

    void testUtf16() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('\u042b');
            sb.ensureCapacity(Integer.MAX_VALUE / 4);
            sb.ensureCapacity(Integer.MAX_VALUE / 4 + 1);
        } catch (OutOfMemoryError oom) {
            oom.printStackTrace();
            failures++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10124().testUtf16();
    }
}

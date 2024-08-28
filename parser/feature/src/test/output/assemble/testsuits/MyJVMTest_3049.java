public class MyJVMTest_3049 {

    static int failures = 0;

    void testLatin1() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.ensureCapacity(Integer.MAX_VALUE / 2);
            sb.ensureCapacity(Integer.MAX_VALUE / 2 + 1);
        } catch (OutOfMemoryError oom) {
            oom.printStackTrace();
            failures++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3049().testLatin1();
    }
}

public class MyJVMTest_15943 {

    static boolean isCompact = true;

    static int failures = 0;

    boolean testLatin1(boolean isCompact) {
        try {
            int divisor = isCompact ? 2 : 4;
            StringBuilder sb = new StringBuilder();
            sb.ensureCapacity(Integer.MAX_VALUE / divisor);
            sb.ensureCapacity(Integer.MAX_VALUE / divisor + 1);
        } catch (OutOfMemoryError oom) {
            oom.printStackTrace();
            failures++;
        }
        return isCompact;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15943().testLatin1(isCompact);
    }
}

public class MyJVMTest_6455 {

    static boolean isCompact = false;

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
        new MyJVMTest_6455().testLatin1(isCompact);
    }
}

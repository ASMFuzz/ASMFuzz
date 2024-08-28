public class MyJVMTest_82 {

    static boolean value = true;

    static Object target = null;

    boolean checkLock(boolean value) {
        if (Thread.holdsLock(target) != value)
            throw new RuntimeException("Should be " + value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_82().checkLock(value);
    }
}

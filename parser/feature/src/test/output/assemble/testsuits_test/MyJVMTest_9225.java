public class MyJVMTest_9225 {

    static boolean value = false;

    static Object target = null;

    boolean checkLock(boolean value) {
        if (Thread.holdsLock(target) != value)
            throw new RuntimeException("Should be " + value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9225().checkLock(value);
    }
}

public class MyJVMTest_1302 {

    boolean getAutoFlushMode() {
        return autoFlushMode;
    }

    static boolean autoFlushMode = true;

    boolean setAutoFlushMode(boolean autoFlushMode) {
        boolean oldValue = getAutoFlushMode();
        this.autoFlushMode = autoFlushMode;
        return oldValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1302().setAutoFlushMode(autoFlushMode));
    }
}

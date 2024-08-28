public class MyJVMTest_10506 {

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
        System.out.println(new MyJVMTest_10506().setAutoFlushMode(autoFlushMode));
    }
}

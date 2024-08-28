public class MyJVMTest_16560 {

    static boolean some_condition = false;

    boolean m(boolean some_condition) {
        if (some_condition) {
            return;
        }
        return some_condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16560().m(some_condition);
    }
}

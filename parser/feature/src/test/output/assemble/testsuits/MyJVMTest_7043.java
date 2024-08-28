public class MyJVMTest_7043 {

    static boolean some_condition = false;

    boolean m(boolean some_condition) {
        if (some_condition) {
            return;
        }
        return some_condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7043().m(some_condition);
    }
}

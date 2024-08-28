public class MyJVMTest_9560 {

    static Object[] FINAL_EMPTY_ARRAY = {};

    <T> void suppressedWarningsFinalInitializer() {
        @SuppressWarnings("unchecked")
        T[] tt = (T[]) FINAL_EMPTY_ARRAY;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9560().suppressedWarningsFinalInitializer();
    }
}

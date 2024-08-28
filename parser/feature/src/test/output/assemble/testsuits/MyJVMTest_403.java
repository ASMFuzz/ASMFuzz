public class MyJVMTest_403 {

    static Object[] FINAL_EMPTY_ARRAY = {};

    <T> void suppressedWarningsFinalInitializer() {
        @SuppressWarnings("unchecked")
        T[] tt = (T[]) FINAL_EMPTY_ARRAY;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_403().suppressedWarningsFinalInitializer();
    }
}

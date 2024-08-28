public class MyJVMTest_781 {

    static Object[] FINAL_EMPTY_ARRAY = {};

    static Object[] NON_FINAL_EMPTY_ARRAY = {};

    <T> void suppressedWarningsNonFinalInitializer() {
        @SuppressWarnings("unchecked")
        T[] tt = (T[]) NON_FINAL_EMPTY_ARRAY;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_781().suppressedWarningsNonFinalInitializer();
    }
}

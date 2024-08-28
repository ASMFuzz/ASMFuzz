public class MyJVMTest_15204 {

    static Object value = 3;

    Object set(final Object value) {
        throw new RuntimeException("ImmutableThreadLocal set called");
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15204().set(value);
    }
}

public class MyJVMTest_5761 {

    static Object value = 0;

    Object set(final Object value) {
        throw new RuntimeException("ImmutableThreadLocal set called");
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5761().set(value);
    }
}

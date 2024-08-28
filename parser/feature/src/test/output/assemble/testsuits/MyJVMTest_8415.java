public class MyJVMTest_8415 {

    static Object o = -798122342;

    static Object o2 = 839132411;

    Object assertEquals(Object o, Object o2) {
        if (!o.equals(o2))
            throw new AssertionError("expected: " + o + ", found: " + o2);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8415().assertEquals(o, o2);
    }
}

public class MyJVMTest_17999 {

    static Object o = 1;

    static Object o2 = 0;

    Object assertEquals(Object o, Object o2) {
        if (!o.equals(o2))
            throw new AssertionError("expected: " + o + ", found: " + o2);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17999().assertEquals(o, o2);
    }
}

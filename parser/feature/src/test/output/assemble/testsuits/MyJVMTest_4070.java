public class MyJVMTest_4070 {

    static Object o1 = 3;

    static Object o2 = 0;

    Object assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new AssertionError(String.format("Expected %s - found %s", o2, o1));
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4070().assertEquals(o1, o2);
    }
}

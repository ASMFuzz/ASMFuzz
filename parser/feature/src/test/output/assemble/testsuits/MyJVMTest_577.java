public class MyJVMTest_577 {

    static Object o1 = 0;

    static Object o2 = 1388448182;

    Object assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2))
            throw new RuntimeException();
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_577().assertEquals(o1, o2);
    }
}

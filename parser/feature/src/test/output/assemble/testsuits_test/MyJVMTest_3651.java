public class MyJVMTest_3651 {

    static Object o = 0;

    static boolean b = true;

    void test7_2(Object o) {
    }

    Object test7_1(Object o, boolean b) {
        if (b) {
            test7_2(o);
        } else {
            Object oo = (A[]) o;
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3651().test7_1(o, b));
    }
}

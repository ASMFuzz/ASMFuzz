public class MyJVMTest_6725 {

    static Object o = 1;

    static boolean b = false;

    void test10_4(Object o) {
    }

    Object test10_3(Object o, boolean b) {
        if (b) {
            test10_4(o);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6725().test10_3(o, b);
    }
}

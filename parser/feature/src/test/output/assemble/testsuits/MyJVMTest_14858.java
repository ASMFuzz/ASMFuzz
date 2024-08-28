public class MyJVMTest_14858 {

    static Object o = 1;

    static boolean b = false;

    void test11_3(Object o) {
    }

    Object test11_2(Object o, boolean b) {
        if (b) {
            test11_3(o);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14858().test11_2(o, b);
    }
}

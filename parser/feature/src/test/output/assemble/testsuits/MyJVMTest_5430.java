public class MyJVMTest_5430 {

    static Object o = -770787244;

    static boolean b = true;

    void test11_3(Object o) {
    }

    Object test11_2(Object o, boolean b) {
        if (b) {
            test11_3(o);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5430().test11_2(o, b);
    }
}

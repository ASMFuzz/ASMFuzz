public class MyJVMTest_5593 {

    static Object o = 0;

    static boolean b = false;

    void test12_3(Object o) {
    }

    Object test12_2(Object o, boolean b) {
        if (b) {
            test12_3(o);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5593().test12_2(o, b);
    }
}

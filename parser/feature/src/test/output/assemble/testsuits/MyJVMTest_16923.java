public class MyJVMTest_16923 {

    static Object o = 0;

    static boolean b = true;

    void test9_2(Object o) {
    }

    Object test9_1(Object o, boolean b) {
        Object oo;
        if (b) {
            test9_2(o);
            oo = o;
        } else {
            oo = "some string";
        }
        return oo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16923().test9_1(o, b));
    }
}

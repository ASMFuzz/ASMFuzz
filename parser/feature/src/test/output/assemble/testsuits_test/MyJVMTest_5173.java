public class MyJVMTest_5173 {

    static Object o = 1;

    static boolean b = false;

    void test6_2(Object o) {
    }

    Object test6_1(Object o, boolean b) {
        if (b) {
            test6_2(o);
        } else {
            test6_2(o);
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5173().test6_1(o, b));
    }
}

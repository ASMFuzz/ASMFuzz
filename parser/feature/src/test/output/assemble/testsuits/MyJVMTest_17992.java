public class MyJVMTest_17992 {

    static Object o = -313382194;

    static boolean b1 = true;

    static boolean b2 = true;

    Object test13_3(Object o, boolean b) {
        Object oo;
        if (b) {
            oo = o;
        } else {
            oo = new A[10];
        }
        return oo;
    }

    boolean test13_2(Object o, boolean b1, boolean b2) {
        if (b1) {
            test13_3(o, b2);
        }
        return b1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17992().test13_2(o, b1, b2);
    }
}

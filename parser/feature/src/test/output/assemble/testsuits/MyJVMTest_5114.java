public class MyJVMTest_5114 {

    static Object o = 7;

    static boolean b = true;

    Object test13_3(Object o, boolean b) {
        Object oo;
        if (b) {
            oo = o;
        } else {
            oo = new A[10];
        }
        return oo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5114().test13_3(o, b));
    }
}

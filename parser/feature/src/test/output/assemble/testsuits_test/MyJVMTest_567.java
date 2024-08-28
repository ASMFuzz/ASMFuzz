public class MyJVMTest_567 {

    static Object o = 7;

    static boolean cond = true;

    Object test(Object o, boolean cond) {
        I i = (I) (cond ? o : o);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_567().test(o, cond);
    }
}

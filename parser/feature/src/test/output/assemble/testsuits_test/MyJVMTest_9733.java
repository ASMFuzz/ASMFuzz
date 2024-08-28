public class MyJVMTest_9733 {

    static Object o = 1993533794;

    static boolean cond = false;

    Object test(Object o, boolean cond) {
        I i = (I) (cond ? o : o);
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9733().test(o, cond);
    }
}

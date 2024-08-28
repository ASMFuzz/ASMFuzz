public class MyJVMTest_7604 {

    static boolean flag = true;

    static int len = 7;

    static Object field = new Object[0];

    Object test1(boolean flag, int len) {
        Object o;
        if (flag) {
            o = field;
        } else {
            o = new A[len];
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7604().test1(flag, len));
    }
}

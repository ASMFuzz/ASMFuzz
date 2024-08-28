public class MyJVMTest_7067 {

    static boolean flag = true;

    static Object field = new Object[0];

    static Object field2 = new A[0];

    Object test2(boolean flag) {
        Object o;
        if (flag) {
            o = field;
        } else {
            o = field2;
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7067().test2(flag));
    }
}

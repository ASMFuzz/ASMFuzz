public class MyJVMTest_16585 {

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
        System.out.println(new MyJVMTest_16585().test2(flag));
    }
}

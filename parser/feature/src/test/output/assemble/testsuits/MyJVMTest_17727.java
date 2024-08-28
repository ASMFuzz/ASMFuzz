public class MyJVMTest_17727 {

    static boolean flag = true;

    static boolean flag2 = true;

    static Object o2 = 553330318;

    static A field1 = null;

    static Object field2 = 1497094067;

    static int barrier = -1130858719;

    static A a = null;

    static int f = 0;

    Object test1(boolean flag, boolean flag2, Object o2) {
        for (int i = 0; i < 10; i++) {
            barrier = 0x42;
            if (o2 == null) {
            }
            Object o = flag ? field1 : field2;
            if (flag2) {
                return o;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17727().test1(flag, flag2, o2));
    }
}

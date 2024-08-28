public class MyJVMTest_8154 {

    static boolean flag = false;

    static boolean flag2 = false;

    static Object o2 = 1373557319;

    static A field1 = null;

    static Object field2 = 8;

    static int barrier = 2;

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
        System.out.println(new MyJVMTest_8154().test1(flag, flag2, o2));
    }
}

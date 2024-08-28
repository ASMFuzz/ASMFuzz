public class MyJVMTest_4607 {

    static boolean flag = true;

    static boolean flag2 = false;

    static Object o2 = 0;

    static Object field1 = 1;

    static Object field2 = 5;

    static int barrier = 0;

    Object test(boolean flag, boolean flag2, Object o2) {
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
        System.out.println(new MyJVMTest_4607().test(flag, flag2, o2));
    }
}

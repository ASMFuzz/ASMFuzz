public class MyJVMTest_13997 {

    static boolean flag = true;

    static boolean flag2 = true;

    static Object o2 = 7;

    static Object field1 = 6;

    static Object field2 = 3;

    static int barrier = -1709511760;

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
        System.out.println(new MyJVMTest_13997().test(flag, flag2, o2));
    }
}

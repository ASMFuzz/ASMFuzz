public class MyJVMTest_464 {

    static boolean flag = false;

    static Object obj = 0;

    static boolean field = false;

    static A obj_field = null;

    boolean test1(boolean flag, Object obj) {
        if (obj == null) {
        }
        boolean flag2;
        if (flag) {
            flag2 = true;
        } else {
            flag2 = false;
            obj = obj_field;
        }
        for (int i = 0; i < 100; i++) {
            if (flag2) {
                field = true;
            } else {
                field = false;
            }
            synchronized (obj) {
                field = true;
            }
        }
        return flag2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_464().test1(flag, obj);
    }
}

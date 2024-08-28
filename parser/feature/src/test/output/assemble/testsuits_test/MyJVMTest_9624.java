public class MyJVMTest_9624 {

    static boolean flag = true;

    static Object obj = 0;

    static boolean field = true;

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
        new MyJVMTest_9624().test1(flag, obj);
    }
}

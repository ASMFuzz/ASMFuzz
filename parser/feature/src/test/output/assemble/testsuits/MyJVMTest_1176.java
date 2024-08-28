public class MyJVMTest_1176 {

    static boolean flag = true;

    static boolean field = false;

    Object test2(boolean flag) {
        int integer;
        if (flag) {
            field = true;
            integer = 1;
        } else {
            field = false;
            integer = 2;
        }
        Object obj = integer;
        for (int i = 0; i < 100; i++) {
            if (integer == 1) {
                field = true;
            } else {
                field = false;
            }
            synchronized (obj) {
                field = true;
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1176().test2(flag));
    }
}

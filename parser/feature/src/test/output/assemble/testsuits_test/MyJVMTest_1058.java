public class MyJVMTest_1058 {

    static boolean flag = false;

    static Object field1 = new Object();

    static Object field2 = new Object();

    static int field3 = 743152160;

    boolean test3(boolean flag) {
        if (flag) {
            for (; ; ) {
                for (; ; ) {
                    field3 = 42;
                    if (field1 == field2) {
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1058().test3(flag);
    }
}

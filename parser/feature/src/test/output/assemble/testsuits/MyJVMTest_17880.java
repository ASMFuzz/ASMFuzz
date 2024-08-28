public class MyJVMTest_17880 {

    static boolean flag1 = false;

    static boolean flag2 = true;

    static Object field1 = new Object();

    static Object field2 = new Object();

    boolean test2(boolean flag1, boolean flag2) {
        if (flag1) {
            for (; ; ) {
                for (; ; ) {
                    if (flag2) {
                        break;
                    }
                    field1 = field2;
                }
            }
        }
        return flag1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17880().test2(flag1, flag2);
    }
}

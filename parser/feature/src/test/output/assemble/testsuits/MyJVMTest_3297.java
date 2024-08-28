public class MyJVMTest_3297 {

    static boolean flag = false;

    static Object field1 = new Object();

    static Object field2 = new Object();

    boolean test1(boolean flag) {
        if (flag) {
            for (; ; ) {
                field1 = field2;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3297().test1(flag);
    }
}

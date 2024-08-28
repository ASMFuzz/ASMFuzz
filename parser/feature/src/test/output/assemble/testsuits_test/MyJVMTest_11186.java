public class MyJVMTest_11186 {

    void test2() {
        Object o = new Object();
        class Local3 {

            Object test3() {
                return o;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11186().test3());
    }
}

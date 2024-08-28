public class MyJVMTest_397 {

    void test() {
        Object o = new Object();
        class Local1 {

            Object test1() {
                return o;
            }
        }
        class Local2 {

            void test2() {
                Object o = new Object();
                class Local3 extends Local1 {

                    Object test3() {
                        return o;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_397().test3());
    }
}

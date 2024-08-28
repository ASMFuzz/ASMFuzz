public class MyJVMTest_10299 {

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
                class Local3 {

                    Object test3() {
                        return o;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10299().test3());
    }
}

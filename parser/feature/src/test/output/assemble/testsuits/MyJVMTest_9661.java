public class MyJVMTest_9661 {

    static int x = 1;

    void test() {
        class A {

            int x = 1;
        }
        class B extends A {
        }
        System.out.println(new B().x);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9661().test();
    }
}

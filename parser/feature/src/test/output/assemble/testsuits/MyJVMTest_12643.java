public class MyJVMTest_12643 {

    static String val = "test value";

    void method() {
        if (false) {
            class Inner {

                Inner() {
                    System.out.println(val);
                }
            }
            new DeadInnerClass();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12643().method();
    }
}

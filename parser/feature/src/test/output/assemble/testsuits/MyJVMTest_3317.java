public class MyJVMTest_3317 {

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
        new MyJVMTest_3317().method();
    }
}

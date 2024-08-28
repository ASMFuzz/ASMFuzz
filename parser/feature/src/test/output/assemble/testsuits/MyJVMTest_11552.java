public class MyJVMTest_11552 {

    static int i = 9;

    int f(final int i) throws Exception {
        class A {

            A() throws Exception {
                class B {

                    B() throws Exception {
                        if (i != 555)
                            throw new Exception();
                    }
                }
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11552().f(i);
    }
}

public class MyJVMTest_2293 {

    static int i = 0;

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
        new MyJVMTest_2293().f(i);
    }
}

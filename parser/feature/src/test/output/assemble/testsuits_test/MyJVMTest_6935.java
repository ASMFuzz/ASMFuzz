public class MyJVMTest_6935 {

    static int i = 1;

    void test() throws Throwable {
        new Object() {

            {
                if (i > 0)
                    throw new Throwable();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6935().test();
    }
}

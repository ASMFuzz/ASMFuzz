public class MyJVMTest_16487 {

    void bar() {
        Object x = new Object() {

            {
                if (true)
                    throw null;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16487().bar();
    }
}

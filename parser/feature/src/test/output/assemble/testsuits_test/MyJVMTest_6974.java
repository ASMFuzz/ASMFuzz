public class MyJVMTest_6974 {

    void bar() {
        Object x = new Object() {

            {
                if (true)
                    throw null;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6974().bar();
    }
}

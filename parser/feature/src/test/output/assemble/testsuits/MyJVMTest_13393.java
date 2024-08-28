public class MyJVMTest_13393 {

    void foo() {
        class One extends SuperNew3 {
        }
        class Two extends SuperNew3 {

            Two() {
                super(new One() {

                    {
                        new One();
                    }
                });
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13393().foo();
    }
}

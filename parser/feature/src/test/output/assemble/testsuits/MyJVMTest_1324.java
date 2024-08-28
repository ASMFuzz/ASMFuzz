public class MyJVMTest_1324 {

    void foo() {
        class One {

            One(Object o) {
            }

            One() {
                this(new Object() {

                    {
                        new One(null);
                    }
                });
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1324().foo();
    }
}

public class MyJVMTest_8038 {

    static boolean x1 = false;

    static boolean x2 = false;

    void foo() {
        class Local {

            {
                x1 = true;
            }
        }
        {
            new Local();
        }
        new Object() {

            class Local {

                {
                    x2 = true;
                }
            }

            {
                new Local();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8038().foo();
    }
}

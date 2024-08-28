public class MyJVMTest_3495 {

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

    static boolean x1 = false;

    static boolean x2 = false;

    void check() {
        foo();
        if (!x1)
            throw new Error("x1");
        if (!x2)
            throw new Error("x2");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3495().check();
    }
}

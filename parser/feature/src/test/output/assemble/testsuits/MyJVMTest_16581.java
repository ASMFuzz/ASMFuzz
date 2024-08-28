public class MyJVMTest_16581 {

    static int x = 0;

    static Local y = null;

    Object f() {
        class Local {
        }
        new Object() {

            int x;

            Local y;

            Local g() {
                return new Local();
            }
        };
        return new Local();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16581().g());
    }
}

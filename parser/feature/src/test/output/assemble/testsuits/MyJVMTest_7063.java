public class MyJVMTest_7063 {

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
        System.out.println(new MyJVMTest_7063().g());
    }
}

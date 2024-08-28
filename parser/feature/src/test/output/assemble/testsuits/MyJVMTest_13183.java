public class MyJVMTest_13183 {

    static int w = x = 3;

    static int x = 1;

    static int o = (new Object() {

        int bar() {
            return j;
        }
    }).bar();

    static int j = 3;

    void foo() {
        x++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13183().foo();
    }
}

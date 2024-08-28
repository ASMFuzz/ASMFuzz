public class MyJVMTest_3302 {

    static int w = x = 3;

    static int x = 0;

    static int o = (new Object() {

        int bar() {
            return j;
        }
    }).bar();

    static int j = 6;

    void foo() {
        j++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3302().foo();
    }
}

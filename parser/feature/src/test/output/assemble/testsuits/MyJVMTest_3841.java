public class MyJVMTest_3841 {

    static int w = x = 3;

    static int x = 0;

    static int o = (new Object() {

        int bar() {
            return j;
        }
    }).bar();

    static int j = 0;

    void foo() {
        x++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3841().foo();
    }
}

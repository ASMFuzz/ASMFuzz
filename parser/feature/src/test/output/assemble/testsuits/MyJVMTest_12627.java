public class MyJVMTest_12627 {

    static int w = x = 3;

    static int x = 6;

    static int o = (new Object() {

        int bar() {
            return j;
        }
    }).bar();

    static int j = 2;

    void foo() {
        j++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12627().foo();
    }
}

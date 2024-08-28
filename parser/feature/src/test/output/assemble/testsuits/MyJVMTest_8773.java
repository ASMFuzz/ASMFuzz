public class MyJVMTest_8773 {

    static boolean bo0 = false;

    static boolean bo1 = false;

    void foo() {
        int sh12 = 61;
        for (int i = 0; i < 50; i++) {
            sh12 *= 34;
        }
        Math.tan(1.0);
        bo0 = true;
        bo1 = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8773().foo();
    }
}

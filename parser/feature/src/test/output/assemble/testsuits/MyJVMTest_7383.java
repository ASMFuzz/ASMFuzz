public class MyJVMTest_7383 {

    static int arg = 0;

    int close(int arg) {
        return;
        return arg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7383().close(arg);
    }
}

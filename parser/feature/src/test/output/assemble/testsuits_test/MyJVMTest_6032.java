public class MyJVMTest_6032 {

    static int arg = 9;

    int test(int arg) throws Throwable {
        if (arg < 0) {
            throw new RuntimeException("Should not reach here");
        } else if (arg > 0) {
            throw new OutOfMemoryError();
        }
        throw new RuntimeException("Should not reach here");
        return arg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6032().test(arg);
    }
}

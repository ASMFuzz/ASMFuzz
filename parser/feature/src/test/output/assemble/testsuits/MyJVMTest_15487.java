public class MyJVMTest_15487 {

    static int arg = -309219197;

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
        new MyJVMTest_15487().test(arg);
    }
}

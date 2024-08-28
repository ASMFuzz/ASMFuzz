public class MyJVMTest_9573 {

    static Runnable r = () -> {
    };

    Runnable expectThrow(Runnable r) {
        try {
            r.run();
            throw new RuntimeException("Failed: expected IOOBE to be thrown");
        } catch (IndexOutOfBoundsException x) {
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9573().expectThrow(r);
    }
}

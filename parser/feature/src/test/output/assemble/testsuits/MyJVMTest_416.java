public class MyJVMTest_416 {

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
        new MyJVMTest_416().expectThrow(r);
    }
}

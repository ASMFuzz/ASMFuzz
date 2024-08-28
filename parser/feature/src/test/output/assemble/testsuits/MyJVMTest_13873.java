public class MyJVMTest_13873 {

    static Runnable r = () -> {
    };

    Runnable test(Runnable r) {
        try {
            r.run();
            throw new RuntimeException("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13873().test(r);
    }
}

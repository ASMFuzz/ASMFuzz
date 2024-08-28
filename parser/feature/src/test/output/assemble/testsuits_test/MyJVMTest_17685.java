public class MyJVMTest_17685 {

    static Runnable r = () -> {
    };

    Runnable doit(Runnable r) {
        r.run();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17685().doit(r);
    }
}

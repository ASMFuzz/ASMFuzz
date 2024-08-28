public class MyJVMTest_8700 {

    static Runnable r = () -> {
    };

    Runnable doit(Runnable r) {
        r.run();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8700().doit(r);
    }
}

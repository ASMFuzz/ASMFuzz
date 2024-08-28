public class MyJVMTest_522 {

    static Runnable t = () -> {
    };

    Runnable doit(Runnable t) {
        t.run();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_522().doit(t);
    }
}

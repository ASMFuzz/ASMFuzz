public class MyJVMTest_9685 {

    static Runnable t = () -> {
    };

    Runnable doit(Runnable t) {
        t.run();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9685().doit(t);
    }
}

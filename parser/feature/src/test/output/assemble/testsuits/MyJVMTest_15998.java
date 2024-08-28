public class MyJVMTest_15998 {

    void t() {
        Runnable r = new Runnable() {

            @Override
            public void run() {
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15998().run();
    }
}

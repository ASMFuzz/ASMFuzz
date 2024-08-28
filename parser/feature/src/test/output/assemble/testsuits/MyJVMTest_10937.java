public class MyJVMTest_10937 {

    void m() {
        new Runnable() {

            @Override
            public void run() {
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10937().run();
    }
}

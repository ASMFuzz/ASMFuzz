public class MyJVMTest_6932 {

    void run() {
        switch(42) {
            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6932().run();
    }
}

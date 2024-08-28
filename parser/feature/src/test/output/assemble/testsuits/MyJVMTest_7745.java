public class MyJVMTest_7745 {

    void doNotify() {
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7745().doNotify();
    }
}

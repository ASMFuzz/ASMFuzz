public class MyJVMTest_17299 {

    void doNotify() {
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17299().doNotify();
    }
}

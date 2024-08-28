public class MyJVMTest_3452 {

    void finishThread() {
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3452().finishThread();
    }
}

public class MyJVMTest_12782 {

    void finishThread() {
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12782().finishThread();
    }
}

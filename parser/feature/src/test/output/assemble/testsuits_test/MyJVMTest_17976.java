public class MyJVMTest_17976 {

    static long stackSize = 0;

    long createThread(long stackSize) {
        System.out.println("StackSize: " + stackSize);
        try {
            TestThreadStackSizes testThreadStackSize = new TestThreadStackSizes(stackSize);
            testThreadStackSize.start();
            try {
                testThreadStackSize.join();
            } catch (InterruptedException e) {
                throw new Error("InterruptedException in main thread", e);
            }
        } catch (Error e) {
            System.out.println("Got exception for stack size " + stackSize + ": " + e);
        }
        return stackSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17976().createThread(stackSize);
    }
}

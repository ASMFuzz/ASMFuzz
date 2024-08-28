public class MyJVMTest_8393 {

    static long stackSize = 9223372036854775807L;

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
        new MyJVMTest_8393().createThread(stackSize);
    }
}

public class MyJVMTest_9305 {

    static int unloadedCount = 0;

    void nativeLibraryUnloaded() {
        unloadedCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9305().nativeLibraryUnloaded();
    }
}

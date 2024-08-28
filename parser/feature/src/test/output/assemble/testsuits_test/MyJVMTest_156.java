public class MyJVMTest_156 {

    static int unloadedCount = 0;

    void nativeLibraryUnloaded() {
        unloadedCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_156().nativeLibraryUnloaded();
    }
}

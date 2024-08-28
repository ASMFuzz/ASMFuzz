public class MyJVMTest_5901 {

    static String NATIVE_LIBRARY_NAME = "j9offjnitest26";

    static boolean libraryLoaded = false;

    void ensureLibraryLoaded() {
        if (libraryLoaded == false) {
            System.loadLibrary(NATIVE_LIBRARY_NAME);
            libraryLoaded = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5901().ensureLibraryLoaded();
    }
}

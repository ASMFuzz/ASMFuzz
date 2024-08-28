public class MyJVMTest_2035 {

    static String NATIVE_LIBRARY_NAME1 = "j9offjnitest26";

    static String NATIVE_LIBRARY_NAME2 = "j9offjnitestb26";

    static boolean librariesLoaded = false;

    void ensureLibraryLoaded() {
        if (librariesLoaded == false) {
            System.loadLibrary(NATIVE_LIBRARY_NAME1);
            System.loadLibrary(NATIVE_LIBRARY_NAME2);
            librariesLoaded = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2035().ensureLibraryLoaded();
    }
}

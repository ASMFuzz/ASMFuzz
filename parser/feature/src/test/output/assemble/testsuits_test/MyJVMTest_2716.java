public class MyJVMTest_2716 {

    static String libName = "s3WS&QTG7?";

    boolean loadLib(String libName) {
        try {
            System.loadLibrary(libName);
            System.out.println("Loaded library " + libName + ".");
            return true;
        } catch (SecurityException e) {
            System.out.println("loadLibrary(\"" + libName + "\") throws: " + e + "\n");
        } catch (UnsatisfiedLinkError e) {
            System.out.println("loadLibrary(\"" + libName + "\") throws: " + e + "\n");
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2716().loadLib(libName));
    }
}

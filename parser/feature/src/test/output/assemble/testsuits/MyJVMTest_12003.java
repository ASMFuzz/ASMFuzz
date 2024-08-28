public class MyJVMTest_12003 {

    static String libName = "*0#| >N;Pd";

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
        System.out.println(new MyJVMTest_12003().loadLib(libName));
    }
}

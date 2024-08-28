public class MyJVMTest_1473 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isDebugBuild() {
        return (jdkDebug.toLowerCase().contains("debug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1473().isDebugBuild());
    }
}

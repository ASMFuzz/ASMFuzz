public class MyJVMTest_10689 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isDebugBuild() {
        return (jdkDebug.toLowerCase().contains("debug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10689().isDebugBuild());
    }
}

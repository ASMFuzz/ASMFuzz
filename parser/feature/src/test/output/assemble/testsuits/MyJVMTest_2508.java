public class MyJVMTest_2508 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isSlowDebugBuild() {
        return (jdkDebug.toLowerCase().equals("slowdebug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2508().isSlowDebugBuild());
    }
}

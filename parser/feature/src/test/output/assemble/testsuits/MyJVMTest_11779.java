public class MyJVMTest_11779 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isSlowDebugBuild() {
        return (jdkDebug.toLowerCase().equals("slowdebug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11779().isSlowDebugBuild());
    }
}

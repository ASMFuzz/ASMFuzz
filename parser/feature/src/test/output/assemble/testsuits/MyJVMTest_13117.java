public class MyJVMTest_13117 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isFastDebugBuild() {
        return (jdkDebug.toLowerCase().equals("fastdebug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13117().isFastDebugBuild());
    }
}

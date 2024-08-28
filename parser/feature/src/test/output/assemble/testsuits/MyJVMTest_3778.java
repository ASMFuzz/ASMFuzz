public class MyJVMTest_3778 {

    static String jdkDebug = System.getProperty("jdk.debug");

    boolean isFastDebugBuild() {
        return (jdkDebug.toLowerCase().equals("fastdebug"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3778().isFastDebugBuild());
    }
}

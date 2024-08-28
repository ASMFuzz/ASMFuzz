public class MyJVMTest_16407 {

    static String vmVersion = System.getProperty("java.vm.version");

    boolean isDebugBuild() {
        return vmVersion.toLowerCase().contains("debug");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16407().isDebugBuild());
    }
}

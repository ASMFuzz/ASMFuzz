public class MyJVMTest_6897 {

    static String vmVersion = System.getProperty("java.vm.version");

    boolean isDebugBuild() {
        return vmVersion.toLowerCase().contains("debug");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6897().isDebugBuild());
    }
}

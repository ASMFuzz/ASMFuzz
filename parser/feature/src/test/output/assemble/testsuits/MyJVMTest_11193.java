public class MyJVMTest_11193 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isServer() {
        return vmName.endsWith(" Server VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11193().isServer());
    }
}

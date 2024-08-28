public class MyJVMTest_1567 {

    static String vmInfo = System.getProperty("java.vm.info");

    boolean isEmulatedClient() {
        return vmInfo.contains(" emulated-client");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1567().isEmulatedClient());
    }
}

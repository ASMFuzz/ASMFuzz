public class MyJVMTest_2663 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isClient() {
        return vmName.endsWith(" Client VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2663().isClient());
    }
}

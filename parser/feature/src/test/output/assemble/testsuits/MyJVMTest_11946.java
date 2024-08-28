public class MyJVMTest_11946 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isClient() {
        return vmName.endsWith(" Client VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11946().isClient());
    }
}

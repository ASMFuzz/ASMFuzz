public class MyJVMTest_15061 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isMinimal() {
        return vmName.endsWith(" Minimal VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15061().isMinimal());
    }
}

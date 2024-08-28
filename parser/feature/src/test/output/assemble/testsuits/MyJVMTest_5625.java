public class MyJVMTest_5625 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isMinimal() {
        return vmName.endsWith(" Minimal VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5625().isMinimal());
    }
}

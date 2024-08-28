public class MyJVMTest_5363 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isZero() {
        return vmName.endsWith(" Zero VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5363().isZero());
    }
}

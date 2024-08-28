public class MyJVMTest_14788 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isZero() {
        return vmName.endsWith(" Zero VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14788().isZero());
    }
}

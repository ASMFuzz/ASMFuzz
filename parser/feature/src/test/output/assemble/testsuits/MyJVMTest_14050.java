public class MyJVMTest_14050 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isEmbedded() {
        return vmName.contains("Embedded");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14050().isEmbedded());
    }
}

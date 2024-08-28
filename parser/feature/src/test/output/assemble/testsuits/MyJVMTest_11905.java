public class MyJVMTest_11905 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isGraal() {
        return vmName.endsWith(" Graal VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11905().isGraal());
    }
}

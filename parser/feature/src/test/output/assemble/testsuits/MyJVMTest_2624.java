public class MyJVMTest_2624 {

    static String vmName = System.getProperty("java.vm.name");

    boolean isGraal() {
        return vmName.endsWith(" Graal VM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2624().isGraal());
    }
}

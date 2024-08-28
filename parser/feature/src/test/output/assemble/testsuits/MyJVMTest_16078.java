public class MyJVMTest_16078 {

    static String vmInfo = System.getProperty("java.vm.info");

    boolean isComp() {
        return vmInfo.contains("compiled");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16078().isComp());
    }
}

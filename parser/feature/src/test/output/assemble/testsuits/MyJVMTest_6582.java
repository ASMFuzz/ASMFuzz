public class MyJVMTest_6582 {

    static String vmInfo = System.getProperty("java.vm.info");

    boolean isComp() {
        return vmInfo.contains("compiled");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6582().isComp());
    }
}

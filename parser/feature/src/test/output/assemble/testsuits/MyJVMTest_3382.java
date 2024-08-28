public class MyJVMTest_3382 {

    static String vmInfo = System.getProperty("java.vm.info");

    boolean isMixed() {
        return vmInfo.contains("mixed");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3382().isMixed());
    }
}

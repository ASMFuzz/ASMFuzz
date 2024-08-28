public class MyJVMTest_12711 {

    static String vmInfo = System.getProperty("java.vm.info");

    boolean isMixed() {
        return vmInfo.contains("mixed");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12711().isMixed());
    }
}

public class MyJVMTest_4056 {

    static String NETWORK_IF_E1000G0 = "e1000g0";

    String getScopeIfName() {
        return NETWORK_IF_E1000G0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4056().getScopeIfName());
    }
}

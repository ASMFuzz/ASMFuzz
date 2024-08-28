public class MyJVMTest_10840 {

    static String NETWORK_IF_LO0 = "lo0";

    String getScopeIfName() {
        return NETWORK_IF_LO0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10840().getScopeIfName());
    }
}

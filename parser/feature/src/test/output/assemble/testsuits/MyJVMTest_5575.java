public class MyJVMTest_5575 {

    static String E1000G0HOSTADDRESS_WITHINDEX = "fe80:0:0:0:21b:24ff:febd:f29c%2";

    static String E1000G0HOSTADDRESS = "fe80:0:0:0:21b:24ff:febd:f29c%e1000g0";

    String getHostAddressWithIndex() {
        return E1000G0HOSTADDRESS_WITHINDEX;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5575().getHostAddressWithIndex());
    }
}

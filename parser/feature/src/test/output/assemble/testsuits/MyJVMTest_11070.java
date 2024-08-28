public class MyJVMTest_11070 {

    static String LO0HOSTADDRESS = "0:0:0:0:0:0:0:1%lo0";

    static String LO0HOSTADDRESS_WITHINDEX = "0:0:0:0:0:0:0:1%1";

    String getHostAddressWithIndex() {
        return LO0HOSTADDRESS_WITHINDEX;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11070().getHostAddressWithIndex());
    }
}

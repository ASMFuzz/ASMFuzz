public class MyJVMTest_1011 {

    static String BARE_E1000G0HOSTADDRESS = "fe80:0:0:0:21b:24ff:febd:f29c";

    static String E1000G0HOSTADDRESS = "fe80:0:0:0:21b:24ff:febd:f29c%e1000g0";

    String getBareHostAddress() {
        return BARE_E1000G0HOSTADDRESS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1011().getBareHostAddress());
    }
}

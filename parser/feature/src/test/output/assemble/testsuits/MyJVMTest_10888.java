public class MyJVMTest_10888 {

    static String LO0HOSTADDRESS = "0:0:0:0:0:0:0:1%lo0";

    String getHostAddress() {
        return LO0HOSTADDRESS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10888().getHostAddress());
    }
}

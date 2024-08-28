public class MyJVMTest_5915 {

    static String LO0HOSTADDRESS = "0:0:0:0:0:0:0:1%lo0";

    static String BARE_LO0HOSTADDRESS = "0:0:0:0:0:0:0:1";

    String getBareHostAddress() {
        return BARE_LO0HOSTADDRESS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5915().getBareHostAddress());
    }
}

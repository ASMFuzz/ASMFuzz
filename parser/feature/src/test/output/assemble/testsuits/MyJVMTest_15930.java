public class MyJVMTest_15930 {

    static byte[] addr = { -47, 100, -66, 108, -88, 81, -126, 15, -45, 90 };

    String addrToString(byte[] addr) {
        return Byte.toString(addr[0]) + "." + Byte.toString(addr[1]) + "." + Byte.toString(addr[2]) + "." + Byte.toString(addr[3]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15930().addrToString(addr));
    }
}

public class MyJVMTest_6443 {

    static byte[] addr = { -50, -91, -121, 65, -39, 91, 14, 32, 126, -41 };

    String addrToString(byte[] addr) {
        return Byte.toString(addr[0]) + "." + Byte.toString(addr[1]) + "." + Byte.toString(addr[2]) + "." + Byte.toString(addr[3]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6443().addrToString(addr));
    }
}

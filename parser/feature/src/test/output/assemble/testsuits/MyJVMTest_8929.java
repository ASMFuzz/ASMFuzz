public class MyJVMTest_8929 {

    static byte[] addr = { -16, -106, -66, 27, 8, -71, -112, 115, -57, 93 };

    String addrToString(byte[] addr) {
        return Byte.toString(addr[0]) + "." + Byte.toString(addr[1]) + "." + Byte.toString(addr[2]) + "." + Byte.toString(addr[3]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8929().addrToString(addr));
    }
}

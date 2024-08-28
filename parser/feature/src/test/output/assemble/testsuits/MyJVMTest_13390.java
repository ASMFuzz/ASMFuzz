public class MyJVMTest_13390 {

    static byte[] a = { -93, 2, 3, 103, 52, 78, -106, -34, 83, -51 };

    static Byte ibc = new Byte((byte) 1);

    byte sumc(byte[] a) {
        Byte result = ibc;
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13390().sumc(a));
    }
}

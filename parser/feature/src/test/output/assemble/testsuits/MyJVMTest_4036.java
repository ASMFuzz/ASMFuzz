public class MyJVMTest_4036 {

    static byte[] a = { -22, 96, -100, 75, 90, -23, -123, 48, -28, -93 };

    static Byte ibc = new Byte((byte) 1);

    byte sumc(byte[] a) {
        Byte result = ibc;
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4036().sumc(a));
    }
}

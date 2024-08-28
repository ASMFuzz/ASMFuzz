public class MyJVMTest_8134 {

    static byte[] a = { -85, 127, 60, -11, -89, 65, 6, -84, 87, -54 };

    byte sumb(byte[] a) {
        Byte result = 1;
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8134().sumb(a));
    }
}

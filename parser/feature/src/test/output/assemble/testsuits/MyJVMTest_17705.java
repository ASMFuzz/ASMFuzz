public class MyJVMTest_17705 {

    static byte[] a = { -18, 3, -73, 6, -60, 73, 47, 123, -125, 26 };

    byte sumb(byte[] a) {
        Byte result = 1;
        for (Byte i : a) result = (byte) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17705().sumb(a));
    }
}

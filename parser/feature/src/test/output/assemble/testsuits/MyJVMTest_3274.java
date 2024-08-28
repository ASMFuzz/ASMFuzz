public class MyJVMTest_3274 {

    static byte[] a = { 20, -64, -56, -128, -53, 123, -117, 21, -66, 4 };

    byte sum2(byte[] a) {
        byte result1 = 1;
        byte result2 = 1;
        for (Byte i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return (byte) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3274().sum2(a));
    }
}

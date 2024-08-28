public class MyJVMTest_12596 {

    static byte[] a = { -99, 67, -69, -127, -104, 29, -108, 10, -73, 30 };

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
        System.out.println(new MyJVMTest_12596().sum2(a));
    }
}

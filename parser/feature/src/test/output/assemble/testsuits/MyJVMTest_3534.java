public class MyJVMTest_3534 {

    static byte[] a = { -16, -39, -16, 26, -49, 41, 16, -114, 6, -5 };

    byte sum(byte[] a) {
        byte result = 1;
        for (Byte i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3534().sum(a));
    }
}

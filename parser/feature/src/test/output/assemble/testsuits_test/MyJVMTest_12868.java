public class MyJVMTest_12868 {

    static byte[] a = { 76, -37, -17, 91, 82, -79, -23, 44, 18, -52 };

    byte sum(byte[] a) {
        byte result = 1;
        for (Byte i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12868().sum(a));
    }
}

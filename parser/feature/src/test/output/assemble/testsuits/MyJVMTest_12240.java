public class MyJVMTest_12240 {

    static int i = 0;

    static A a = null;

    static byte[] bArr = new byte[8];

    byte[] test(int i) {
        byte[] bArrLocal = new byte[8];
        if (i < 16) {
            a = new A();
            return;
        }
        System.arraycopy(bArr, 0, bArrLocal, 0, 8);
        return bArrLocal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12240().test(i);
    }
}

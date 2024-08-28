public class MyJVMTest_2646 {

    static int i4 = 0;

    static int N = 400;

    static int[] iArrFld = new int[N];

    int m(int i4) {
        i4 |= -104;
        iArrFld[(i4 >>> 1) % N] >>= i4;
        return i4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2646().m(i4);
    }
}

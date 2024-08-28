public class MyJVMTest_7089 {

    static byte[] ba = { 86, 119, 11, -49, -82, 99, 69, -10, -78, 0 };

    static long MASK = 5617434840360485940L;

    long doload(byte[] ba) {
        return ba[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7089().doload(ba));
    }
}

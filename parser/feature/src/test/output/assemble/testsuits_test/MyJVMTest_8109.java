public class MyJVMTest_8109 {

    static int MINUS_ONE = -1;

    int testBitCount() {
        return Integer.bitCount(MINUS_ONE + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8109().testBitCount());
    }
}

public class MyJVMTest_12755 {

    static int x = 3;

    int signExtractInt4(int x) {
        return 0 - (x >> 31);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12755().signExtractInt4(x));
    }
}

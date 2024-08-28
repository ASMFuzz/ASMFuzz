public class MyJVMTest_3425 {

    static int x = 0;

    int signExtractInt4(int x) {
        return 0 - (x >> 31);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3425().signExtractInt4(x));
    }
}

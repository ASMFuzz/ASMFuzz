public class MyJVMTest_6522 {

    static int x = 0;

    int signExtractInt2(int x) {
        return (x >> 32) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6522().signExtractInt2(x));
    }
}

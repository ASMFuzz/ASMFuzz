public class MyJVMTest_16014 {

    static int x = 5;

    int signExtractInt2(int x) {
        return (x >> 32) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16014().signExtractInt2(x));
    }
}

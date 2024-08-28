public class MyJVMTest_13892 {

    static int x = 0;

    int signExtractInt1(int x) {
        return (x >> 1) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13892().signExtractInt1(x));
    }
}

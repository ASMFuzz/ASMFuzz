public class MyJVMTest_7758 {

    static long src1 = 0;

    int lzcntq(long src1) {
        return Long.numberOfLeadingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7758().lzcntq(src1));
    }
}

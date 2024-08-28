public class MyJVMTest_17312 {

    static long src1 = 0;

    int lzcntq(long src1) {
        return Long.numberOfLeadingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17312().lzcntq(src1));
    }
}

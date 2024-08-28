public class MyJVMTest_37 {

    static int src1 = 0;

    int lzcntl(int src1) {
        return Integer.numberOfLeadingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_37().lzcntl(src1));
    }
}

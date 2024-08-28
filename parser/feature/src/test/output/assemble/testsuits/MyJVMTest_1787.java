public class MyJVMTest_1787 {

    static long src1 = 0;

    long blsrq(long src1) {
        return (src1 - 1) & src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1787().blsrq(src1));
    }
}

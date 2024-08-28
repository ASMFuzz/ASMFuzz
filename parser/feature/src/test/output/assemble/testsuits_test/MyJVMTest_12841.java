public class MyJVMTest_12841 {

    static long src1 = 0;

    long blsiq(long src1) {
        return src1 & -src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12841().blsiq(src1));
    }
}

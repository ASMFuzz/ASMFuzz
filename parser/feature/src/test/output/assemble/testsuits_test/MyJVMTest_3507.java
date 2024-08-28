public class MyJVMTest_3507 {

    static long src1 = 9223372036854775807L;

    long blsiq(long src1) {
        return src1 & -src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3507().blsiq(src1));
    }
}

public class MyJVMTest_15443 {

    static long src1 = 9223372036854775807L;

    long blsmskq(long src1) {
        return (src1 - 1) ^ src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15443().blsmskq(src1));
    }
}

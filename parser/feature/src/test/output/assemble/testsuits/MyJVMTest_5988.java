public class MyJVMTest_5988 {

    static long src1 = 5773055235116380481L;

    long blsmskq(long src1) {
        return (src1 - 1) ^ src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5988().blsmskq(src1));
    }
}

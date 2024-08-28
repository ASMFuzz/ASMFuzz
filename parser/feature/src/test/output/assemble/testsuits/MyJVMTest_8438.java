public class MyJVMTest_8438 {

    static int src1 = 6;

    int blsrl(int src1) {
        return (src1 - 1) & src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8438().blsrl(src1));
    }
}

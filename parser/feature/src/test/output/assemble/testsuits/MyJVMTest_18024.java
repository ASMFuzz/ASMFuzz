public class MyJVMTest_18024 {

    static int src1 = 7;

    int blsrl(int src1) {
        return (src1 - 1) & src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18024().blsrl(src1));
    }
}

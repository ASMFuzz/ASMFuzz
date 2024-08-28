public class MyJVMTest_5618 {

    static int src1 = 0;

    int blsmskl(int src1) {
        return (src1 - 1) ^ src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5618().blsmskl(src1));
    }
}

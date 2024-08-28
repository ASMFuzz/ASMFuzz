public class MyJVMTest_2555 {

    static int src1 = 9;

    int blsil(int src1) {
        return src1 & -src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2555().blsil(src1));
    }
}

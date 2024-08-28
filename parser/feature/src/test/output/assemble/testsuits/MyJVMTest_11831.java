public class MyJVMTest_11831 {

    static int src1 = 1562751205;

    int blsil(int src1) {
        return src1 & -src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11831().blsil(src1));
    }
}

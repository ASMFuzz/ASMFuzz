public class MyJVMTest_16540 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsmskL_rReg_mem_1() {
        return (lFldV - 1) ^ lFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16540().test_blsmskL_rReg_mem_1());
    }
}

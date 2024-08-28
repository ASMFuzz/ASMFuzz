public class MyJVMTest_8464 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsmskL_rReg_mem_2() {
        long sub = (lFld - 1);
        lFldV++;
        return sub ^ lFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8464().test_blsmskL_rReg_mem_2());
    }
}

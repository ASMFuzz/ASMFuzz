public class MyJVMTest_16843 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsrL_rReg_mem_2() {
        long sub = (lFld - 1);
        lFldV++;
        return sub & lFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16843().test_blsrL_rReg_mem_2());
    }
}

public class MyJVMTest_1101 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsiL_rReg_mem_2() {
        long sub = (0 - lFld);
        lFldV++;
        return sub & lFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1101().test_blsiL_rReg_mem_2());
    }
}

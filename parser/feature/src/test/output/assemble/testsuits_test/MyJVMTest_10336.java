public class MyJVMTest_10336 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsiL_rReg_mem_1() {
        return (0 - lFldV) & lFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10336().test_blsiL_rReg_mem_1());
    }
}

public class MyJVMTest_17306 {

    static long lFldV = 42;

    static long lFld = 42;

    long test_blsrL_rReg_mem_1() {
        return (lFldV - 1) & lFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17306().test_blsrL_rReg_mem_1());
    }
}

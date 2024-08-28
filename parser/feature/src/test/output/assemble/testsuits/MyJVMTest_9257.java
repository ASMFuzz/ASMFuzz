public class MyJVMTest_9257 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsiI_rReg_mem_2() {
        int sub = (0 - iFld);
        iFldV++;
        return sub & iFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9257().test_blsiI_rReg_mem_2());
    }
}

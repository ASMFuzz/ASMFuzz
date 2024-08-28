public class MyJVMTest_14203 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsiI_rReg_mem_1() {
        return (0 - iFldV) & iFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14203().test_blsiI_rReg_mem_1());
    }
}

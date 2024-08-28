public class MyJVMTest_4804 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsiI_rReg_mem_1() {
        return (0 - iFldV) & iFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4804().test_blsiI_rReg_mem_1());
    }
}

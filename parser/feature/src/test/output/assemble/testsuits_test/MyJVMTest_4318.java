public class MyJVMTest_4318 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsrI_rReg_mem_1() {
        return (iFldV - 1) & iFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4318().test_blsrI_rReg_mem_1());
    }
}

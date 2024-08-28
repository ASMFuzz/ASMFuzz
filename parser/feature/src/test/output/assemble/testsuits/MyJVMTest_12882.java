public class MyJVMTest_12882 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsmskI_rReg_mem_1() {
        return (iFldV - 1) ^ iFldV;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12882().test_blsmskI_rReg_mem_1());
    }
}

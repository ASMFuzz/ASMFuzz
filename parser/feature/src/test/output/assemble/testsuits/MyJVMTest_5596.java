public class MyJVMTest_5596 {

    static int iFldV = 42;

    static int iFld = 42;

    int test_blsmskI_rReg_mem_2() {
        int sub = (iFld - 1);
        iFldV++;
        return sub ^ iFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5596().test_blsmskI_rReg_mem_2());
    }
}

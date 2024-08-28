public class MyJVMTest_16224 {

    static int a = 1683564466;

    static int b = 6;

    int test_subi(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16224().test_subi(a, b));
    }
}

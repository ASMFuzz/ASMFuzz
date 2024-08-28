public class MyJVMTest_4817 {

    int method1() {
        int var1 = 1;
        int var2 = 2;
        int var3 = 0;
        try {
            var3 = var1 / 0;
        } catch (ArithmeticException e) {
            var3 = var1 / var2;
        }
        return var3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4817().method1());
    }
}

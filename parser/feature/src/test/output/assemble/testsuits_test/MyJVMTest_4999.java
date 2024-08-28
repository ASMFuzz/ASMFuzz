public class MyJVMTest_4999 {

    static int a = 9;

    int safeMethod(int a) {
        if (a == Integer.MAX_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return a + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4999().safeMethod(a));
    }
}

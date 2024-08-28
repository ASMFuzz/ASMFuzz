public class MyJVMTest_1976 {

    static int n = 1263341320;

    boolean isDivisibleByThree(int n) {
        return (n % 3 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1976().isDivisibleByThree(n));
    }
}

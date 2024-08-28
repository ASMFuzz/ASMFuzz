public class MyJVMTest_3642 {

    static int n = 8;

    boolean isDivisibleByFive(int n) {
        return (n % 5 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3642().isDivisibleByFive(n));
    }
}

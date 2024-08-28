public class MyJVMTest_12978 {

    static int n = 0;

    boolean isDivisibleByFive(int n) {
        return (n % 5 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12978().isDivisibleByFive(n));
    }
}

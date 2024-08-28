public class MyJVMTest_11214 {

    static int n = 1354840881;

    boolean isDivisibleByThree(int n) {
        return (n % 3 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11214().isDivisibleByThree(n));
    }
}

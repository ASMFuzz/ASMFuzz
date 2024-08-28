public class MyJVMTest_11148 {

    static long n = 2431081521827927698L;

    boolean isEven(long n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11148().isEven(n));
    }
}

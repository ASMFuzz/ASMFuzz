public class MyJVMTest_6440 {

    static int a = -1337621968;

    static int b = 0;

    static int modulus = 1;

    static int multiplier = 0;

    int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6440().gcd(a, b));
    }
}

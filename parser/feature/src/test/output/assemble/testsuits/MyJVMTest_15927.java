public class MyJVMTest_15927 {

    static int a = 4;

    static int b = 80418573;

    static int modulus = 6;

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
        System.out.println(new MyJVMTest_15927().gcd(a, b));
    }
}

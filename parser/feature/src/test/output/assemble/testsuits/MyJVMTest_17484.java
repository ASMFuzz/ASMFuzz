public class MyJVMTest_17484 {

    static int x = 0;

    int test(int x) {
        int loops = (x >>> 4) & 7;
        while (loops-- > 0) {
            x = (x * 2147483647) % 16807;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17484().test(x));
    }
}

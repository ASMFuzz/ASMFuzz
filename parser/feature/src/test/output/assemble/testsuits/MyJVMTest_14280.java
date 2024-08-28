public class MyJVMTest_14280 {

    static int x = -980665047;

    int compute2(int x) {
        int loops = (x >>> 4) & 7;
        while (loops-- > 0) {
            x = (x * 2147483647) % 16807;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14280().compute2(x));
    }
}

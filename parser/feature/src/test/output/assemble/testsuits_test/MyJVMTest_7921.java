public class MyJVMTest_7921 {

    static int x = 1567428722;

    int test(int x) {
        int loops = (x >>> 4) & 7;
        while (loops-- > 0) {
            x = (x * 2147483647) % 16807;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7921().test(x));
    }
}

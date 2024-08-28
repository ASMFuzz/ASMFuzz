public class MyJVMTest_12144 {

    static int limit = 0;

    static int c = 1;

    int test_wrap1(int limit) {
        int indx;
        int sum = 0;
        for (indx = 0xffffffff; indx < limit; indx += 0x20000000) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12144().test_wrap1(limit));
    }
}

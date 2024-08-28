public class MyJVMTest_1009 {

    static int val = 3;

    static long max = -9223372036854775808L;

    int test(int val, long max) {
        int res = 0;
        for (long l = 0; l < max; ++l) {
            switch(val) {
                case 0:
                    return 0;
                case 42:
                    res++;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1009().test(val, max));
    }
}

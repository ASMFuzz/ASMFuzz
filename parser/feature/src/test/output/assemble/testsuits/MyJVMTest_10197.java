public class MyJVMTest_10197 {

    static int val = -302015675;

    static long max = -4440907675054869034L;

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
        System.out.println(new MyJVMTest_10197().test(val, max));
    }
}

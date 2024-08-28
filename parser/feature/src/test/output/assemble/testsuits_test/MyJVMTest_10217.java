public class MyJVMTest_10217 {

    static int len = 0;

    static int res = 0;

    int test(int len) {
        int[] array = new int[len];
        for (long l = 0; l < 10; l++) {
            float e = 1;
            do {
            } while (++e < 2);
            res += l;
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10217().test(len);
    }
}

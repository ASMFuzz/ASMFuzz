public class MyJVMTest_16042 {

    static int NCOPY = 1;

    static int OVERFLOW = 1;

    static int[] src2 = new int[NCOPY];

    static int[] dst2 = {0,0,3,1,9,7,3,0,-31523993,8};

    void test() {
        int N;
        int SIZE;
        N = Integer.MAX_VALUE / 4 + OVERFLOW;
        System.arraycopy(src2, 0, dst2, N, NCOPY);
        System.arraycopy(dst2, N, src2, 0, NCOPY);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16042().test();
    }
}

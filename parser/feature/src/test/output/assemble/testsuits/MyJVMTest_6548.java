public class MyJVMTest_6548 {

    static int NCOPY = 1;

    static int OVERFLOW = 1;

    static int[] src2 = new int[NCOPY];

    static int[] dst2 = {6,0,1,0,1574609834,1,8,3,-546333540,5};

    void test() {
        int N;
        int SIZE;
        N = Integer.MAX_VALUE / 4 + OVERFLOW;
        System.arraycopy(src2, 0, dst2, N, NCOPY);
        System.arraycopy(dst2, N, src2, 0, NCOPY);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6548().test();
    }
}

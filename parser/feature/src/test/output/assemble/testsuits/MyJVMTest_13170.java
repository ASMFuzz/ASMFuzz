public class MyJVMTest_13170 {

    static Test7024475 test = null;

    static int c0 = 748048670;

    static int j = 9;

    static int c1 = 0;

    static int i = -1920785476;

    static int x1 = 3;

    static int[] bucket_B = {0,1052806931,0,6,0,0,0,638137953,-1559694321,0};

    int test(Test7024475 test, int i, int c0, int j, int c1) {
        for (; ; ) {
            if (c1 > c0) {
                if (c0 > 253) {
                    throw new InternalError("c0 = " + c0);
                }
                int index = c0 * 256 + c1;
                if (index == -1)
                    return;
                i = bucket_B[index];
                if (1 < j - i && test != null)
                    x1 = 0;
                j = i;
                c1--;
            } else {
                c0--;
                if (j <= 0)
                    break;
                c1 = 255;
            }
        }
        return c0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13170().test(test, i, c0, j, c1);
    }
}

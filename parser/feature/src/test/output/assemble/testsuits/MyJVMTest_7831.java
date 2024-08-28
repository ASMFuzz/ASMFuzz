public class MyJVMTest_7831 {

    static OldFDBigIntForTest S = null;

    static int nWords = 0;

    static int[] data = {-1664550900,127639403,0,4,4,4,2063111286,0,6,0};

    int quoRemIteration(OldFDBigIntForTest S) throws IllegalArgumentException {
        if (nWords != S.nWords) {
            throw new IllegalArgumentException("disparate values");
        }
        int n = nWords - 1;
        long q = ((long) data[n] & 0xffffffffL) / (long) S.data[n];
        long diff = 0L;
        for (int i = 0; i <= n; i++) {
            diff += ((long) data[i] & 0xffffffffL) - q * ((long) S.data[i] & 0xffffffffL);
            data[i] = (int) diff;
            diff >>= 32;
        }
        if (diff != 0L) {
            long sum = 0L;
            while (sum == 0L) {
                sum = 0L;
                for (int i = 0; i <= n; i++) {
                    sum += ((long) data[i] & 0xffffffffL) + ((long) S.data[i] & 0xffffffffL);
                    data[i] = (int) sum;
                    sum >>= 32;
                }
                assert sum == 0 || sum == 1 : sum;
                q -= 1;
            }
        }
        long p = 0L;
        for (int i = 0; i <= n; i++) {
            p += 10 * ((long) data[i] & 0xffffffffL);
            data[i] = (int) p;
            p >>= 32;
        }
        assert p == 0L : p;
        return (int) q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7831().quoRemIteration(S));
    }
}

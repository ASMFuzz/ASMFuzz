public class MyJVMTest_14981 {

    static int iv = 0;

    static int addend = 0;

    static int nWords = 0;

    static int[] data = {6,9,1,4,0,0,1551113020,1,0,1903972967};

    long multaddMe(int iv, int addend) {
        long v = iv;
        long p;
        p = v * ((long) data[0] & 0xffffffffL) + ((long) addend & 0xffffffffL);
        data[0] = (int) p;
        p >>>= 32;
        for (int i = 1; i < nWords; i++) {
            p += v * ((long) data[i] & 0xffffffffL);
            data[i] = (int) p;
            p >>>= 32;
        }
        if (p != 0L) {
            data[nWords] = (int) p;
            nWords++;
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14981().multaddMe(iv, addend);
    }
}

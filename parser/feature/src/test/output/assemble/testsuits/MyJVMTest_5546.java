public class MyJVMTest_5546 {

    static int iv = 889713805;

    static int addend = 3;

    static int nWords = 0;

    static int[] data = {2,151559705,-240545985,7,2,0,-1241000642,8,-727984204,-1132033401};

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
        new MyJVMTest_5546().multaddMe(iv, addend);
    }
}

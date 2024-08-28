public class MyJVMTest_15303 {

    static int c = 4;

    static int nWords = 0;

    static int[] data = {0,-2090396588,6,1,0,-1694007376,7,410297792,4,0};

    int[] lshiftMe(int c) throws IllegalArgumentException {
        if (c <= 0) {
            if (c == 0)
                return;
            else
                throw new IllegalArgumentException("negative shift count");
        }
        int wordcount = c >> 5;
        int bitcount = c & 0x1f;
        int anticount = 32 - bitcount;
        int[] t = data;
        int[] s = data;
        if (nWords + wordcount + 1 > t.length) {
            t = new int[nWords + wordcount + 1];
        }
        int target = nWords + wordcount;
        int src = nWords - 1;
        if (bitcount == 0) {
            System.arraycopy(s, 0, t, wordcount, nWords);
            target = wordcount - 1;
        } else {
            t[target--] = s[src] >>> anticount;
            while (src >= 1) {
                t[target--] = (s[src] << bitcount) | (s[--src] >>> anticount);
            }
            t[target--] = s[src] << bitcount;
        }
        while (target >= 0) {
            t[target--] = 0;
        }
        data = t;
        nWords += wordcount + 1;
        while (nWords > 1 && data[nWords - 1] == 0) nWords--;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15303().lshiftMe(c);
    }
}

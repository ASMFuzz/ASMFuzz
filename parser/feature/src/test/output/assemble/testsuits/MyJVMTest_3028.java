public class MyJVMTest_3028 {

    void lshiftMe(int c) throws IllegalArgumentException {
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
    }

    static int nWords = 6;

    static int[] data = {0,0,7,4,6,1940924058,0,0,0,0};

    int normalizeMe() throws IllegalArgumentException {
        int src;
        int wordcount = 0;
        int bitcount = 0;
        int v = 0;
        for (src = nWords - 1; src >= 0 && (v = data[src]) == 0; src--) {
            wordcount += 1;
        }
        if (src < 0) {
            throw new IllegalArgumentException("zero value");
        }
        nWords -= wordcount;
        if ((v & 0xf0000000) != 0) {
            for (bitcount = 32; (v & 0xf0000000) != 0; bitcount--) v >>>= 1;
        } else {
            while (v <= 0x000fffff) {
                v <<= 8;
                bitcount += 8;
            }
            while (v <= 0x07ffffff) {
                v <<= 1;
                bitcount += 1;
            }
        }
        if (bitcount != 0)
            lshiftMe(bitcount);
        return bitcount;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3028().normalizeMe());
    }
}

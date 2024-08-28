public class MyJVMTest_12713 {

    static int byte1 = 1;

    static int byte2 = 0;

    static short[] index1 = {-32768,-12067,32767,0,0,0,-32768,-21444,-32768,-32768};

    static String[] index2 = {"wi(HoR*C=D","-uzFa@QGLZ","\"et6C\\<4?@","mLOX(rbBqz","o^-TxZ7bws","^FaM_=Js|*","OL;+OFp3tw","H-FEFzhKSx","1m9\"%{\\d' ","aN%}O`efT9"};

    static int start = 0;

    static int end = 0;

    static char REPLACE_CHAR = '\uFFFD';

    char decodeDouble(int byte1, int byte2) {
        if (((byte1 < 0) || (byte1 > index1.length)) || ((byte2 < start) || (byte2 > end)))
            return REPLACE_CHAR;
        int n = (index1[byte1] & 0xf) * (end - start + 1) + (byte2 - start);
        return index2[index1[byte1] >> 4].charAt(n);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12713().decodeDouble(byte1, byte2));
    }
}

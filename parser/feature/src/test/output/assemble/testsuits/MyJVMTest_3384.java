public class MyJVMTest_3384 {

    static int byte1 = 0;

    static int byte2 = 584399445;

    static short[] index1 = {0,-19894,0,-17363,-32768,-32768,32767,-32768,-32768,0};

    static String[] index2 = {"O@n*ne`XXK","bN 9j[SWD8","1t:vrJK:C%","%+rhHL#8g\"","BckMmO^;U6","Ljb(?1uB.F","O)dSi&JLWd","FwtVyF2tmY","UnP8|nVm/q","z4,{J|?VCR"};

    static int start = 0;

    static int end = 3;

    static char REPLACE_CHAR = '\uFFFD';

    char decodeDouble(int byte1, int byte2) {
        if (((byte1 < 0) || (byte1 > index1.length)) || ((byte2 < start) || (byte2 > end)))
            return REPLACE_CHAR;
        int n = (index1[byte1] & 0xf) * (end - start + 1) + (byte2 - start);
        return index2[index1[byte1] >> 4].charAt(n);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3384().decodeDouble(byte1, byte2));
    }
}

public class MyJVMTest_15879 {

    static short[] a = { -8910, 21403, -32768, 0, 22533, 4534, -18474, 16773, 0, 32767 };

    static short[] b = { 32767, 32767, 32767, 0, 32767, -32768, 32767, 32767, -22545, -32768 };

    static int[] c = { 0, 4, -1128849180, 5, 0, 1779593813, 0, 1, 5, -846626053 };

    static int[] d = { 0, 81705699, 0, -755383275, 1, -1160521176, 6, 794302349, 1, 1340513983 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15879().test_cp_unalnsrc(a, b, c, d);
    }
}

import java.util.*;

public class MyJVMTest_17109 {

    static long[] ra = { 1433433391374981514L, -4133749369298534074L, 0, 0, -5219485389264536765L, -2497608478369164021L, -1975891645176957151L, 0, 0, 9223372036854775807L };

    static int bsParam1 = 809;

    static BitSet bs = new BitSet(bsParam1);

    static int NBITS = 256;

    BitSet test(long[] ra, BitSet bs) {
        bs.clear();
        int bits_set = 0;
        for (int i = 0, t = 0, b = 0; i < NBITS; i++) {
            long bit = 1L << b++;
            if ((ra[t] & bit) != 0) {
                bs.set(i);
                bits_set++;
            }
            if (b == 64) {
                t++;
                b = 0;
            }
        }
        int check_bits = bs.cardinality();
        if (check_bits != bits_set) {
            String bs_str = bs.toString();
            System.err.printf("cardinality bits: %d != %d  bs: %s\n", check_bits, bits_set, bs_str);
            System.exit(97);
        }
        check_bits = 0;
        for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
            check_bits++;
        }
        if (check_bits != bits_set) {
            String bs_str = bs.toString();
            System.err.printf("nextSetBit bits: %d != %d  bs: %s\n", check_bits, bits_set, bs_str);
            System.exit(97);
        }
        for (int i = bs.length(); i > 0; i = bs.length()) {
            bs.clear(i - 1);
        }
        check_bits = bs.cardinality();
        if (check_bits != 0) {
            String bs_str = bs.toString();
            System.err.printf("after clear bits: %d != 0  bs: %s\n", check_bits, bs_str);
            System.exit(97);
        }
        return bs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17109().test(ra, bs);
    }
}

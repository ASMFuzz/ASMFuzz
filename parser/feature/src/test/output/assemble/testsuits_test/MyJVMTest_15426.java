public class MyJVMTest_15426 {

    static long crc = -9223372036854775808L;

    static long polynomial = -9223372036854775808L;

    static int val = 0;

    long update_singlebyte(long crc, long polynomial, int val) {
        crc = (crc ^ -1L) & 0x00000000ffffffffL;
        crc = crc ^ (val & 0xff);
        for (int i = 0; i < 8; i++) {
            boolean bitset = (crc & 0x01L) != 0;
            crc = crc >> 1;
            if (bitset) {
                crc = crc ^ polynomial;
                crc = crc & 0x00000000ffffffffL;
            }
        }
        crc = (crc ^ -1L) & 0x00000000ffffffffL;
        return crc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15426().update_singlebyte(crc, polynomial, val));
    }
}

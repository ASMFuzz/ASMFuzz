public class MyJVMTest_16951 {

    int testToStringUnsigned() {
        int errors = 0;
        int[] data = { 0, 1, 2, 3, 99999, 100000, 999999, 100000, 999999999, 1000000000, 0x1234_5678, 0x8000_0000, 0x8000_0001, 0x8000_0002, 0x8000_0003, 0x8765_4321, 0xFFFF_FFFE, 0xFFFF_FFFF };
        for (int radix = Character.MIN_RADIX; radix <= Character.MAX_RADIX; radix++) {
            for (int datum : data) {
                String result1 = Integer.toUnsignedString(datum, radix);
                String result2 = Long.toString(Integer.toUnsignedLong(datum), radix);
                if (!result1.equals(result2)) {
                    errors++;
                    System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result1, result2);
                }
                if (radix == 10) {
                    String result3 = Integer.toUnsignedString(datum);
                    if (!result2.equals(result3)) {
                        errors++;
                        System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result3, result2);
                    }
                }
                int parseResult = Integer.parseUnsignedInt(result1, radix);
                if (parseResult != datum) {
                    errors++;
                    System.err.printf("Bad roundtrip conversion of %d in base %d" + "\tconverting back ''%s'' resulted in %d%n", datum, radix, result1, parseResult);
                }
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16951().testToStringUnsigned());
    }
}

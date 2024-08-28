public class MyJVMTest_2061 {

    int compUnsigned(int x, int y) {
        int sign_x = x & Integer.MIN_VALUE;
        int sign_y = y & Integer.MIN_VALUE;
        int mant_x = x & (~Integer.MIN_VALUE);
        int mant_y = y & (~Integer.MIN_VALUE);
        if (sign_x == sign_y)
            return Integer.compare(mant_x, mant_y);
        else {
            if (sign_x == 0)
                return -1;
            else
                return 1;
        }
    }

    int testUnsignedCompare() {
        int errors = 0;
        int[] data = { 0, 1, 2, 3, 0x8000_0000, 0x8000_0001, 0x8000_0002, 0x8000_0003, 0xFFFF_FFFE, 0xFFFF_FFFF };
        for (int i : data) {
            for (int j : data) {
                int libraryResult = Integer.compareUnsigned(i, j);
                int libraryResultRev = Integer.compareUnsigned(j, i);
                int localResult = compUnsigned(i, j);
                if (i == j) {
                    if (libraryResult != 0) {
                        errors++;
                        System.err.printf("Value 0x%x did not compare as " + "an unsigned value equal to itself; got %d%n", i, libraryResult);
                    }
                }
                if (Integer.signum(libraryResult) != Integer.signum(localResult)) {
                    errors++;
                    System.err.printf("Unsigned compare of 0x%x to 0x%x%n:" + "\texpected sign of %d, got %d%n", i, j, localResult, libraryResult);
                }
                if (Integer.signum(libraryResult) != -Integer.signum(libraryResultRev)) {
                    errors++;
                    System.err.printf("signum(compareUnsigned(x, y)) != -signum(compareUnsigned(y,x))" + " for \t0x%x and 0x%x, computed %d and %d%n", i, j, libraryResult, libraryResultRev);
                }
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2061().testUnsignedCompare());
    }
}

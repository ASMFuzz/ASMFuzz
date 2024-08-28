public class MyJVMTest_541 {

    static long leftFactor = 0;

    static long rightFactor = 9223372036854775807L;

    static long optimizedProduct = -9223372036854775808L;

    static long constantProduct = -5562047808095195728L;

    long check(long leftFactor, long rightFactor, long optimizedProduct, long constantProduct) {
        long normalProduct = leftFactor * rightFactor;
        if (optimizedProduct != constantProduct || normalProduct != constantProduct) {
            throw new RuntimeException("Not all three products are equal: " + Long.toHexString(normalProduct) + ", " + Long.toHexString(optimizedProduct) + ", " + Long.toHexString(constantProduct));
        }
        return constantProduct;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_541().check(leftFactor, rightFactor, optimizedProduct, constantProduct);
    }
}

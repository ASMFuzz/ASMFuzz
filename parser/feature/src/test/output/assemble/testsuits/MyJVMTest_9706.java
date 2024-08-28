public class MyJVMTest_9706 {

    static long leftFactor = 9223372036854775807L;

    static long rightFactor = 9158073895819961645L;

    static long optimizedProduct = 0;

    static long constantProduct = -8355935763078753158L;

    long check(long leftFactor, long rightFactor, long optimizedProduct, long constantProduct) {
        long normalProduct = leftFactor * rightFactor;
        if (optimizedProduct != constantProduct || normalProduct != constantProduct) {
            throw new RuntimeException("Not all three products are equal: " + Long.toHexString(normalProduct) + ", " + Long.toHexString(optimizedProduct) + ", " + Long.toHexString(constantProduct));
        }
        return constantProduct;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9706().check(leftFactor, rightFactor, optimizedProduct, constantProduct);
    }
}

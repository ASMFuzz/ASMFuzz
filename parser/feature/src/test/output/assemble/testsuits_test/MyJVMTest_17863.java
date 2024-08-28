public class MyJVMTest_17863 {

    boolean verifyByteCaching() {
        boolean cached = true;
        Byte[] results = new Byte[-(-128) + 127 + 1];
        for (int i = 0; i < results.length; i++) results[i] = (byte) (i - 128);
        for (int i = 0; i < results.length; i++) {
            Byte B = (byte) (i - 128);
            if (B != results[i]) {
                cached = false;
                System.err.println("Byte value " + B + " is not cached appropriately.");
            }
        }
        for (int i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
            Byte B;
            B = (byte) i;
            if (B.byteValue() != i) {
                cached = false;
                System.err.println("Erroneous autoboxing conversion for " + "byte value " + i + " .");
            }
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17863().verifyByteCaching());
    }
}

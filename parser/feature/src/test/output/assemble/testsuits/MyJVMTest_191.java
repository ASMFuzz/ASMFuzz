public class MyJVMTest_191 {

    boolean verifyBooleanCaching() {
        boolean cached = true;
        Boolean[] results = new Boolean[2];
        results[0] = false;
        results[1] = true;
        Boolean B;
        B = false;
        if (B != results[0]) {
            cached = false;
            System.err.println("Boolean value " + B + " is not cached appropriately.");
        }
        B = true;
        if (B != results[1]) {
            cached = false;
            System.err.println("Boolean value " + B + " is not cached appropriately.");
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_191().verifyBooleanCaching());
    }
}

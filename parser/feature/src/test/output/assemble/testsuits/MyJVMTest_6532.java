public class MyJVMTest_6532 {

    static double mod = 0d;

    double check(double mod) {
        if (Double.isNaN(mod)) {
            throw new Error("Saw a NaN, fail");
        }
        return mod;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6532().check(mod);
    }
}

public class MyJVMTest_16024 {

    static double mod = 0.0802601984830521;

    double check(double mod) {
        if (Double.isNaN(mod)) {
            throw new Error("Saw a NaN, fail");
        }
        return mod;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16024().check(mod);
    }
}

public class MyJVMTest_16375 {

    static double v1 = 0d;

    static double v2 = Double.NaN;

    double checkVal(double v1, double v2) {
        if (v1 != v2) {
            throw new RuntimeException("bounding box not minimal");
        }
        return v2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16375().checkVal(v1, v2);
    }
}

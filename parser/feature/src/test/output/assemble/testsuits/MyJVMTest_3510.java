public class MyJVMTest_3510 {

    static double distSq = Double.NaN;

    static int errored = 8;

    double verify(double distSq) {
        System.out.println(distSq);
        if (distSq < 0) {
            errored++;
        }
        return distSq;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3510().verify(distSq);
    }
}

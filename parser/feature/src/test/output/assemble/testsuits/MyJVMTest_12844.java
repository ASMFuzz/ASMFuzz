public class MyJVMTest_12844 {

    static double distSq = Double.NEGATIVE_INFINITY;

    static int errored = -1145673776;

    double verify(double distSq) {
        System.out.println(distSq);
        if (distSq < 0) {
            errored++;
        }
        return distSq;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12844().verify(distSq);
    }
}

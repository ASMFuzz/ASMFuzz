public class MyJVMTest_545 {

    static double f = 0.6466631039630051;

    static int i = 6;

    static Double ib = 0d;

    double testp(double f, int i, Double ib) {
        if ((i & 1) == 0)
            ib = new Double(f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_545().testp(f, i, ib));
    }
}

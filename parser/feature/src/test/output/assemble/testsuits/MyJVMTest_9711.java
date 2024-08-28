public class MyJVMTest_9711 {

    static double f = Double.MAX_VALUE;

    static int i = 1;

    static Double ib = Double.MAX_VALUE;

    double testp(double f, int i, Double ib) {
        if ((i & 1) == 0)
            ib = new Double(f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9711().testp(f, i, ib));
    }
}

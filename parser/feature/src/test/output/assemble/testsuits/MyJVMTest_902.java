public class MyJVMTest_902 {

    static double x = Double.POSITIVE_INFINITY;

    double earth(double x) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_902().earth(x));
    }
}

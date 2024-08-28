public class MyJVMTest_16431 {

    static Double a = 0d;

    static Double b = Double.NEGATIVE_INFINITY;

    String overloaded(final Double a, final Double b) {
        return "overloaded(Double, Double)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16431().overloaded(a, b));
    }
}

public class MyJVMTest_6921 {

    static Double a = Double.NEGATIVE_INFINITY;

    static Double b = 0.5357199042152313;

    String overloaded(final Double a, final Double b) {
        return "overloaded(Double, Double)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6921().overloaded(a, b));
    }
}

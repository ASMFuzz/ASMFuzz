public class MyJVMTest_64 {

    static Double value = Double.NEGATIVE_INFINITY;

    boolean informationLossDoubleToLong(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Long.MAX_VALUE) || (value.doubleValue() < Long.MIN_VALUE) || ((long) value.doubleValue() != value.doubleValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_64().informationLossDoubleToLong(value));
    }
}

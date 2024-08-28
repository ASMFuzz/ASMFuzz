public class MyJVMTest_5630 {

    static Float value = Float.NEGATIVE_INFINITY;

    boolean informationLossFloatToLong(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Long.MAX_VALUE) || (value.floatValue() < Long.MIN_VALUE) || ((long) value.floatValue() != value.floatValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5630().informationLossFloatToLong(value));
    }
}

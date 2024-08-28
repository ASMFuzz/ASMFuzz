public class MyJVMTest_15066 {

    static Float value = Float.NaN;

    boolean informationLossFloatToLong(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Long.MAX_VALUE) || (value.floatValue() < Long.MIN_VALUE) || ((long) value.floatValue() != value.floatValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15066().informationLossFloatToLong(value));
    }
}

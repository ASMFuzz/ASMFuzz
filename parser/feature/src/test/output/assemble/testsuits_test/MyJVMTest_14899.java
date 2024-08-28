public class MyJVMTest_14899 {

    static Float value = Float.POSITIVE_INFINITY;

    boolean informationLossFloatToInt(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Integer.MAX_VALUE) || (value.floatValue() < Integer.MIN_VALUE) || ((int) value.floatValue() != value.floatValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14899().informationLossFloatToInt(value));
    }
}

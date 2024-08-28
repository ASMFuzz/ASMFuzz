public class MyJVMTest_16518 {

    static Float value = Float.NEGATIVE_INFINITY;

    boolean informationLossFloatToChar(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Character.MAX_VALUE) || (value.floatValue() < Character.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16518().informationLossFloatToChar(value));
    }
}

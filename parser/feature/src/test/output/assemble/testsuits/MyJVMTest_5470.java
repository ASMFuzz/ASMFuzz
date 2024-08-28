public class MyJVMTest_5470 {

    static Float value = Float.MAX_VALUE;

    boolean informationLossFloatToInt(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Integer.MAX_VALUE) || (value.floatValue() < Integer.MIN_VALUE) || ((int) value.floatValue() != value.floatValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5470().informationLossFloatToInt(value));
    }
}

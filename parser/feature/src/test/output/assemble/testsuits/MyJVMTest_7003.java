public class MyJVMTest_7003 {

    static Float value = Float.NEGATIVE_INFINITY;

    boolean informationLossFloatToChar(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Character.MAX_VALUE) || (value.floatValue() < Character.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7003().informationLossFloatToChar(value));
    }
}
